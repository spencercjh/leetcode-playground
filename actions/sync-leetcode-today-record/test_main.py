import json
from unittest import TestCase

from main import kebab_case_to_upper_camel_case, kebab_case_to_camel_sentence, setup_java_source_file_for_commit, \
    setup_java_test_file_for_commit


class Test(TestCase):
    def test_kebab_case_to_upper_camel_case(self):
        self.assertEqual('TwoSum', kebab_case_to_upper_camel_case('two-sum'))
        self.assertEqual('', kebab_case_to_upper_camel_case(''))
        # noinspection PyTypeChecker
        self.assertEqual('', kebab_case_to_upper_camel_case(None))

    def test_add_space_to_upper_camel_case(self):
        self.assertEqual('Two Sum', kebab_case_to_camel_sentence('two-sum'))
        self.assertEqual('', kebab_case_to_camel_sentence(''))
        # noinspection PyTypeChecker
        self.assertEqual('', kebab_case_to_camel_sentence(None))

    def test_setup_java_file_for_commit(self):
        body = setup_java_source_file_for_commit('1', 'two-sum')
        print(json.dumps(body))
        print(body['content'])

    def test_setup_java_test_file_for_commit(self):
        body = setup_java_test_file_for_commit('1', 'two-sum')
        print(json.dumps(body))
        print(body['content'])
