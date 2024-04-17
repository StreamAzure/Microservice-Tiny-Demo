from flask import Flask
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

# 设置数据库连接地址
DB_URI = 'mysql://root:123456@mysql:3306/demo'
app.config['SQLALCHEMY_DATABASE_URI'] = DB_URI
# 是否追踪数据库修改，一般不开启, 会影响性能
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False
# 是否显示底层执行的SQL语句
app.config['SQLALCHEMY_ECHO'] = True
# 初始化db，关联flask项目
db = SQLAlchemy(app)

# 定义模型
class Station(db.Model):
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80))
    location = db.Column(db.String(80))

@app.route("/")
def hello():
    return "Hello, I'm station service!"

@app.route("/station/<id>")
def getStation(id):
    station = Station.query.get(id)
    if station:
        return f'Station found: {station.name}, {station.location}'
    else:
        return 'Station not found'

if __name__ == '__main__':
    app.run()

