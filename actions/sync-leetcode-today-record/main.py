import os
import sys

import requests
from github import Github, GithubException

GITHUB_TOKEN = os.getenv("INPUT_GITHUB_TOKEN")
REPOSITORY = os.getenv("INPUT_REPOSITORY")
BRANCH = os.getenv("INPUT_BRANCH")


def get_today_record() -> dict:
    url = "https://leetcode-cn.com/graphql"
    payload = "{\"query\":\"query questionOfToday{\\r\\n    todayRecord{\\r\\n        question{\\r\\n            questionFrontendId\\r\\n            questionTitleSlug\\r\\n        }\\r\\n        date\\r\\n    }\\r\\n}\",\"variables\":{}}"
    headers = {
        'accept': '*/*',
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36',
        'content-type': 'application/json',
        'Sec-Fetch-Site': 'same-origin',
        'Sec-Fetch-Mode': 'cors',
        'Sec-Fetch-Dest': 'empty'
    }
    response = requests.post(url, headers=headers, data=payload)
    _question = response.json()['data']['todayRecord'][0]['question']
    return {"id": _question['questionFrontendId'], "title-slug": _question['questionTitleSlug']}


def setup_java_source_file_for_commit(_id: str, title_slug: str) -> dict:
    class_name = kebab_case_to_upper_camel_case(title_slug)
    return {
        "path": f"src/main/java/spencercjh/problems/{class_name}.java",
        "message": f'{_id}: {kebab_case_to_camel_sentence(title_slug)}',
        # FIXME: better coding about indentation for Java code here
        "content": setup_java_source_file_content(class_name, title_slug)
    }


def setup_java_source_file_content(class_name, title_slug):
    return """package spencercjh.problems;
           
import javax.inject.Singleton;
            
/**
 * https://leetcode-cn.com/problems/%s/
 *
 * @author spencercjh
 */
@Singleton
public class %s{

}
        """ % (title_slug, class_name)


def setup_java_test_file_for_commit(_id: str, title_slug: str) -> dict:
    class_name = kebab_case_to_upper_camel_case(title_slug)
    return {
        "path": f"src/test/java/spencercjh/problems/{class_name}Test.java",
        "message": f'{_id}: {kebab_case_to_camel_sentence(title_slug)} (Test)',
        # FIXME: better coding about indentation for Java code here
        "content": setup_java_test_file_content(class_name)
    }


def setup_java_test_file_content(class_name):
    return """package spencercjh.problems;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;


@MicronautTest
class %sTest {
  @Inject
  private %s solution;

}
        """ % (class_name, class_name)


def kebab_case_to_upper_camel_case(kebab_str: str) -> str:
    """
    kebab case to upper camel case
    :param kebab_str: example: two-sum
    :return: example: TwoSum
    """
    return ''.join(word.title() for word in kebab_str.split("-")) if kebab_str else ''


def kebab_case_to_camel_sentence(kebab_str: str) -> str:
    """
    kebab case to space-separated str
    :param kebab_str: example: two-sum
    :return: example: Two Sum
    """
    return ' '.join(word.title() for word in kebab_str.split("-")) if kebab_str else ''


if __name__ == '__main__':
    if not GITHUB_TOKEN:
        print('Empty github token')
        sys.exit(1)
    if not REPOSITORY:
        print('Empty repository')
        sys.exit(1)
    if not BRANCH:
        print("Empty BRANCH")
        sys.exit(1)

    g = Github(GITHUB_TOKEN)
    try:
        repo = g.get_repo(REPOSITORY)
    except GithubException:
        print(
            "Authentication Error. Try saving a GitHub Token in your Repo Secrets or Use the GitHub Actions Token,"
            " which is automatically used by the action.")
        sys.exit(1)
    today_record: dict = get_today_record()
    _id = today_record['id']
    title_slug = today_record['title-slug']
    files = [setup_java_source_file_for_commit(_id, title_slug), setup_java_test_file_for_commit(_id, title_slug)]
    print("Checking existence======================================================================")
    to_create_files = []
    for file in files:
        try:
            repo.get_contents(file['path'], BRANCH)
            print(f"{file['path']} exists")
        except Exception as e:
            # FIXME: Try not to use try-catch to control own business
            print(e)
            print(f"{file['path']} doesn't exist or something wrong because other cause")
            to_create_files.append(file)
    print("Creating files==========================================================================")
    for file in to_create_files:
        try:
            file_path = file['path']
            create_response = repo.create_file(file_path, file['message'], file['content'], BRANCH)
            print(f"Success create file to {BRANCH}/{file_path} with response: {create_response}")
        except Exception as e:
            print(e)
            print(f'Current file: {file}')
