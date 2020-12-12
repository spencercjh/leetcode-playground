import json

import requests

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

response = requests.request("POST", url, headers=headers, data=payload)

print(json.dumps(response.json()))
