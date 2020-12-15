import os
import sys

from github import Github, GithubException

from leetcode import LeetCodeClient, LeetCodeQuestion

GITHUB_TOKEN = os.getenv("INPUT_GITHUB_TOKEN")
REPOSITORY = os.getenv("INPUT_REPOSITORY")
BRANCH = os.getenv("INPUT_BRANCH")
USER = os.getenv("INPUT_USER", 'bot')
LANGUAGE = os.getenv("INPUT_LANGUAGE", 'Java')

lc_client = LeetCodeClient(LANGUAGE, USER)

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
    if not USER:
        print("Empty USER")
        sys.exit(1)

    g = Github(GITHUB_TOKEN)
    try:
        repo = g.get_repo(REPOSITORY)
    except GithubException:
        print(
            "Authentication Error. Try saving a GitHub Token in your Repo Secrets or Use the GitHub Actions Token,"
            " which is automatically used by the action.")
        sys.exit(1)

    question_of_today = lc_client.question_of_today()
    question_data = lc_client.question_data(question_of_today.title_slug)
    question_of_today.set_code_snippet(
        LeetCodeQuestion.get_one_language_code_snippets_from_question_data(LANGUAGE, question_data))

    print(f'Sync question: {question_of_today.to_json()}')

    print("Checking existence======================================================================")
    to_create_files = []
    for file in [question_of_today.setup_source_file(), question_of_today.setup_test_file()]:
        try:
            repo.get_contents(file.path, BRANCH)
            print(f"{file.path} exists")
        except Exception as e:
            # FIXME: Try not to use try-catch to control own business
            print(e)
            print(f"{file.path} does not exist or something wrong because other cause")
            to_create_files.append(file)

    print("Creating files==========================================================================")
    for file in to_create_files:
        try:
            file_path = file.path
            create_response = repo.create_file(file_path, file.message, file.content, BRANCH)
            print(f"Success create file to {BRANCH}/{file_path} with response: {create_response}")
        except Exception as e:
            print(e)
            print(f'Current file: {file}')
