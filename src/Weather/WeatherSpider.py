"""			<dl class="weather_info">			<dt><img src="http://content.pic.tianqistatic.com/content/20170918/0f64a9643cd8a42fa5f52fddd4ddc8ee.jpg" alt="成都天气预报"></dt>			<dd class="name"><h2>成都</h2><i><a href="/chinacity.html">[切换城市]</a></i></dd>			<dd class="week">2018年12月21日　星期五　戊戌年冬月十五 冬至</dd>			<dd class="weather">				<i><img src="//static.tianqistatic.com/static/wap2018/ico1/b2.png" ></i>				<p class="now"><b>7</b><i>℃</i></p>				<span><b>阴</b>7 ~ 13℃</span>			</dd>				<dd class="shidu"><b>湿度：98%</b><b>风向：西北风 2级</b><b>紫外线：弱</b></dd>			<dd class="kongqi" ><h5 style="background-color:#c67901;">空气质量：轻度污染</h5><h6>PM: 136</h6><span>日出: 07:56<br />日落: 18:06</span></dd>		<dl>"""from random import choiceimport sysimport urllibfrom bs4 import BeautifulSoupimport requestsimport Configureclass Weather:    date = ""    soup = ""    humidity = ""    quanity = ""    now = ""    callbackinfo = []    def __init__(self, place):        url = "http://www.tianqi.com/" + place        header = {'user-agent': choice(Configure.FakeUserAgents),                  'Referer': r'https://www.tianqi.com/'}        req = urllib.request.Request(url, headers=header)        page = urllib.request.urlopen(req).read()        page = page.decode('utf-8')        self.soup = page        # print(self.soup)        self.check()    def check(self):        self.soup = BeautifulSoup(self.soup, "html.parser")        try:            for div in self.soup.find_all('div', {'class': 'left'}):                self.location = div.find('dd', {'class': 'name'}).text[:-6]                self.callbackinfo.append(self.location)                self.date = div.find('dd', {'class': 'week'}).text                self.callbackinfo.append(self.date[0:11])                self.callbackinfo.append(self.date[12:15])                self.humidity = div.find('dd', {'class': 'shidu'}).text                self.callbackinfo.append(self.humidity[0:6])                self.now = div.find('dd', {'class': 'weather'}).text                self.callbackinfo.append(self.now[2:4])                for h5 in div.find('dd', {'class': 'kongqi'}):                    self.callbackinfo.append(h5.text)        except:            print("")        for i in range(len(self.callbackinfo)):            print(self.callbackinfo[i])if __name__ == '__main__':    a = []    for i in range(1, len(sys.argv)):        a.append(sys.argv[i])    Weather(a[0])    # Weather("chengdu")