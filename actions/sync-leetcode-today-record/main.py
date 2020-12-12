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


def setup_java_file_for_commit(_id: str, title_slug: str) -> dict:
    return {
        # TODO title-slug to other format
        # TODO official java class file name
        "path": f"src/main/java/spencercjh/problems/test.txt",
        "message": f'{_id}: {title_slug}',
        "content": f'{title_slug}'
    }


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
    record_java_file = setup_java_file_for_commit(today_record['id'], today_record['title-slug'])
    create_response = repo.create_file(record_java_file['path'], record_java_file['message'],
                                       record_java_file['content'], BRANCH)
    print(f"Success create file with response: {create_response}")
