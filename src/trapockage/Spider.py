import sysfrom bs4 import BeautifulSoupfrom googletrans import Translatorimport requestsimport re# anthor : Comiii# 2018/12/4class Tranlate():    Result = ""    def __init__(self, text, flag):        translator = Translator()        if (flag == 1):  # 涓枃            result = translator.translate(text, dest="EN")            # print(result.text)        elif (flag == 2):  # 鑻辫            result = translator.translate(text, dest="zh-CN")            # print(result.text)        elif (flag == 3):  # 鏃ヨ            result = translator.translate(text, dest="ja")        elif (flag == 4):            result = translator.translate(text, dest="zh-CN")        self.Result = result.textclass Spider():    Result = ''    Soup = ''    def __init__(self, KWord):        #         url="http://www.youdao.com/w/"+KWord+"/#keyfrom=dict2.top"  鏈夐亾璇嶅吀        url = "http://www.iciba.com/" + KWord  # 閲戝北璇嶉湼锛屾墍鏈夋煡鎵剧被鍨嬩竴涓舰寮�        bs = {            'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36'}        r = requests.get(url, headers=bs, timeout=60)        self.Result = r.text        self.CheckBeautifulsoup()    #  涓嶆�绘槸鏈夋晥 into 鏈夐亾璇嶅吀,useful into 閲戝北璇嶉湼    #  beautifulsoup    def CheckBeautifulsoup(self):        soup = BeautifulSoup(self.Result, "html.parser")        # 璇嶉湼缈昏瘧鍣ㄧ埇鍙�        try:            #  <div style="width: 580px; margin-top: 15px; font-size: 15px; line-height: 24px; color: #333333;">浣犲湪璇翠粈涔堬紵</div>            for div in soup.find_all(name='div',                                     style="width: 580px; margin-top: 15px; font-size: 18px; line-height: 24px; color: #333333;"):                soup = div.find(text=True).strip()                self.Soup = soup        except:            print(" ")        # 缃戦〉鐖彇        try:            for li in soup.find_all(name='li', attrs='clearfix'):                for span in li.find_all(name='span'):                    soup = span.find(text=True).strip()                    # print(soup)  # 澶氫釜缁撴灉锛屽叏閮ㄦ樉绀猴紝鏈�缁堜娇鐢�                    self.Soup = soup            # 鍗曚釜缁撴灉锛屽彲鑳界炕璇戝璞′笉瀵�            # print(soup)        except:            print("")    # 涓嶆兂鍐欎簡鎬庝箞鍔炲憸鍛�  .QAQ .    #                    ..     ..    #                   ..        ...    # re姝ｅ垯琛ㄨ揪寮�    def CheckRe(self):        pattern = re.compile(r'')if __name__ == "__main__":    a = []    for i in range(1, len(sys.argv)):        a.append(sys.argv[i])    text = a[0]    flag = int(a[1])    tra_flag = int(a[2])    if tra_flag == 0:        tra = Tranlate(text, flag)        print(tra.Result)    elif tra_flag == 1:        kingt = Spider(text)  # 浼氬嚭鐜版湁缁撴灉鍗翠笉鏄剧ず鐨勯棶棰�        print(kingt.Soup)