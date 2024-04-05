import mitmproxy.http
import time
from mitmproxy import ctx
from mitmproxy import flowfilter

class AddHeader:
    def __init__(self):
        self.num = 0

    def request(self, flow):
        ctx.log.info("request url: %s" % flow.request.url)
        # 添加延迟
        time.sleep(5)  # 这里延迟5秒，你可以根据需要修改
        # 添加自定义的请求头
        flow.request.headers["X-My-Key"] = "my value"

    def response(self, flow):
        ctx.log.info("response url: %s" % flow.request.url)
        self.num = self.num + 1
        flow.response.headers["count"] = str(self.num)

addons = [
    AddHeader()
]