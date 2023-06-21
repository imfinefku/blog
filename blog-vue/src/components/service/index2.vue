<template>
    <div>
        <div style="width:100%;height:70px;line-height:70px;background: white;">
            <div style="width:1200px;margin: 0 auto;height: 100%;">
                <div style="float:left;cursor: pointer;font-size:23px;color:#1abc9c;" @click="index()">Java十点半
                </div>
                <div class="top" style="float:left;margin-left:30px;cursor: pointer;" @click="index()">首页</div>
                <div class="top" style="float:left;margin-left:30px;cursor: pointer;" @click="guidang()">归档</div>
                <div class="top" style="float:left;margin-left:30px;cursor: pointer;" @click="message()">留言板</div>
                <div style="float:right;margin-right:30px;">
                    <el-input placeholder="搜索博客" v-model="keyword">
                        <el-button slot="append" icon="el-icon-search" @click="search()"></el-button>
                    </el-input>
                </div>
            </div>
        </div>
        <div style="width: 1200px;margin: auto;margin-top: 15px;background: #f6f6f6;">
            <div id="left" style="width:770px;float: left;">
                <router-view></router-view>
            </div>
            <div id="right" style="width:400px;float: right;">
                <div style="height: 300px;background: white;">
                    <div
                        style="margin-left:30px;margin-right:30px;line-height:40px;height:40px;border-bottom:1px dashed #e0e0e0;">
                        个人名片</div>
                    <div style="width:100%;float:left;">
                        <div style="float:left;">
                            <img src="../../../static/images/me.jpg"
                                style="width: 100px;height:100px;margin-left:30px;margin-top: 10px;" />
                        </div>
                        <div
                            style="line-height:26px;font-size:13px;margin-left:20px;float:left;width: 230px;height: 100px;margin-top: 10px;">
                            <div style="width: 100%;">昵称：Java十点半</div>
                            <div style="width: 100%;">职业：全栈工程师</div>
                            <div style="width: 100%;">微信：tttxas123</div>
                            <div style="width: 100%;">Q Q：3550469342</div>
                        </div>
                    </div>
                    <div style="line-height:30px;margin-top:10px;float: left;margin-left: 30px;margin-right: 30px;">
                        <i style="color:black!important;">一声霹雳一把剑，一群猛虎钢七连；钢铁的意志钢铁汉，铁血卫国保家园；杀声吓破敌人胆，百战百胜美名传；攻必克，守必坚，踏敌尸骨唱凯旋！</i>
                    </div>
                </div>
                <div style="margin-top:15px;background: white;">
                    <div
                        style="margin-left:30px;margin-right:30px;line-height:40px;height:40px;border-bottom:1px dashed #e0e0e0;">
                        最近更新</div>
                    <li v-for="item in zjgx" @click="content(item.id)"
                        style="cursor: pointer;padding-left:10px;font-size:13px;margin-left:30px;margin-right:30px;height:40px;line-height:40px;background:#f6f6f6;margin-top:10px;border-radius:5px;">
                        {{ item.title }}
                    </li>
                    <div style="width:100%;height:20px;"></div>
                </div>
                <div style="margin-top:15px;background: white;">
                    <div
                        style="margin-left:30px;margin-right:30px;line-height:40px;height:40px;border-bottom:1px dashed #e0e0e0;">
                        点击排行</div>
                    <div v-for="(item, index) in paihang" @click="content(item.id)"
                        style="cursor: pointer;padding-left:10px;font-size:13px;margin-left:30px;margin-right:30px;height:40px;line-height:40px;background:#f6f6f6;margin-top:10px;border-radius:5px;">
                        <div v-if="index < 3"
                            style="text-align:center;width:15px;height:15px;margin-top:12.5px;line-height:15px;float:left;color:white;background:#FF6600;">
                            {{ index + 1 }}</div>
                        <div v-else
                            style="text-align:center;width:15px;height:15px;margin-top:12.5px;line-height:15px;float:left;color:white;background:#B1B1B1;">
                            {{ index + 1 }}</div>
                        <div style="margin-left:10px;float:left;">{{ item.title }}</div>
                    </div>
                    <div style="width:100%;height:20px;"></div>
                </div>
                <div style="margin-top:15px;background: white;">
                    <div
                        style="margin-left:30px;margin-right:30px;line-height:40px;height:40px;border-bottom:1px dashed #e0e0e0;">
                        友情链接</div>
                    <div v-for="item in friend" @click="tofriend(item.url)"
                        style="cursor: pointer;padding-left:10px;font-size:13px;margin-left:30px;margin-right:30px;height:40px;line-height:40px;background:#f6f6f6;margin-top:10px;border-radius:5px;">
                        <div style="float:left;margin-top: 5px;"><img style="width:20px;height:20px;" v-if="item.icon"
                                :src="item.icon" /></div>
                        <div style="float:left;margin-left: 10px;">{{ item.name }}</div>
                    </div>
                    <div style="width:100%;height:20px;"></div>
                </div>
                <div style="margin-top:15px;background: white;margin-bottom: 15px;">
                    <div
                        style="margin-left:30px;margin-right:30px;line-height:40px;height:40px;border-bottom:1px dashed #e0e0e0;">
                        微信公众号</div>
                    <div><img style="margin-left:18px;height:200px;width:200px;"
                            src="../../../static/images/gongzhonghao.jpg" /></div>
                    <div style="width:100%;height:20px;"></div>
                </div>
            </div>
        </div>
        <div style="text-align:center;float:left;width: 100%;margin: auto;height:50px;line-height:50px;background: white;">
            Copyright © Java十点半
        </div>
    </div>
</template>
<script>
import global from '../data/data.js';
export default {
    data() {
        return {
            zjgx: [],
            friend: [
                { "name": "Java十点半github首页", "url": "https://github.com/imfinefku", "icon": "../../../static/images/github.ico" },
                { "name": "Java十点半gitee首页", "url": "https://gitee.com/xd12345", "icon": "../../../static/images/gitee.ico" },
                { "name": "Java十点半B站首页", "url": "https://space.bilibili.com/142398862?spm_id_from=333.1007.0.0", "icon": "../../../static/images/blibli.ico" },
                { "name": "Java十点半知乎首页", "url": "https://www.zhihu.com/people/wo-zhi-hui-crud", "icon": "../../../static/images/zhihu.ico" }
            ],
            paihang: [],
            keyword: "",
            imgViewUrl: ""
        };
    },
    methods: {
        search() {
            if (this.keyword == null || this.keyword == "") {
                this.index();
            } else {
                var that = this;
                that.$router.push({
                    path: '/search',
                    query: {
                        keyword: that.keyword
                    }
                });
            }
        },
        index() {
            this.$router.push({
                path: '/'
            });
        },
        guidang() {
            this.$router.push({
                path: '/guidang'
            });
        },
        message() {
            this.$router.push({
                path: '/messageBoard'
            });
        },
        getHeight() {
            this.defaultHeight.height = window.innerHeight - 1 + "px";
        },
        getZjgx() {
            var temp = [];
            for (var i = 0; i < global.allBlog.length; i++) {
                var tempData = global.allBlog[i];
                if (tempData.title.length > 20) {
                    tempData.title = tempData.title.substring(0, 20) + "...";
                }
                temp.push(tempData);
                if (temp.length >= 4) {
                    break;
                }
            }
            this.zjgx = temp;
        },
        getPaiHang() {
            var temGlobal = global.allBlog;
            var temp = [];
            for (var i = 0; i < temGlobal.length; i++) {
                var tempData = temGlobal[i];
                if (tempData.title.length > 20) {
                    tempData.title = tempData.title.substring(0, 20) + "...";
                }
                temp.push(tempData);
                if (temp.length >= 6) {
                    break;
                }
            }
            this.paihang = temp;
        },
        tofriend(url) {
            window.open(url);
        },
        content(id) {
            const routeData = this.$router.resolve({
                path: '/content',
                query: {
                    id: id
                }
            });
            window.open(routeData.href, "_blank");
        }
    },
    mounted() {
        this.getZjgx();
        this.getPaiHang();
    },
    beforeCreate() {
        document.querySelector('html').setAttribute('style', 'background: #E9EAED;');
    },
    beforeDestroy() {
        document.querySelector('html').removeAttribute('style');
    }
}
</script>
<style>
body {
    margin: 0 auto;
}

.top {
    color: #555;
}

.top:hover {
    color: #1abc9c;
}
</style>