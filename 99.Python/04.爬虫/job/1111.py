import requests
import pandas as pd
import time
from urllib.parse import quote

# 配置参数
headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36',
    'Referer': 'https://www.zhaopin.com/'
}


def fetch_jobs(keyword, city, max_pages=5):
    base_url = "https://fe-api.zhaopin.com/c/i/sou"
    city_code = 854  # 银川城市代码（智联招聘）
    jobs = []

    for page in range(max_pages):
        params = {
            'start': page * 60,
            'pageSize': 60,
            'cityId': city_code,
            'kw': keyword,
            'kt': 3
        }

        try:
            response = requests.get(base_url, params=params, headers=headers)
            response.raise_for_status()
            data = response.json()
            print(data)

            for item in data.get('data', {}).get('results', []):
                job = {
                    '职位名称': item.get('jobName'),
                    '公司名称': item.get('company', {}).get('name'),
                    '工作地点': item.get('city', {}).get('display'),
                    '薪资范围': item.get('salary'),
                    '经验要求': item.get('workingExp', {}).get('name'),
                    '学历要求': item.get('eduLevel', {}).get('name'),
                    '发布时间': item.get('time'),
                    '职位链接': item.get('positionURL')
                }
                jobs.append(job)

            print(f'已爬取第 {page + 1} 页数据')
            time.sleep(1)  # 防止请求过快

        except Exception as e:
            print(f'第 {page + 1} 页请求失败:', e)

    return jobs


# 执行爬取
if __name__ == '__main__':
    keyword = '化验员'
    city = '银川'

    print('开始爬取招聘信息...')
    job_data = fetch_jobs(keyword, city, max_pages=3)

    # 保存到Excel
    if job_data:
        df = pd.DataFrame(job_data)
        df.to_excel('银川化验员招聘信息.xlsx', index=False, engine='openpyxl')
        print(f'已保存 {len(df)} 条数据到 Excel 文件')
    else:
        print('未爬取到数据')
