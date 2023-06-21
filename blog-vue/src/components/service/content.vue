<template>
    <div style="background: white;width: 100%;margin: 0 auto;">
        <div style="width:100%;height:60px;"></div>
        <div style="width:616px;margin:0 auto;font-size: 24px;font-weight:300;">{{ title }}</div>
        <div style="width:616px;margin:0 auto;border-top:1px dashed #e0e0e0;margin-top:10px;margin-bottom:10px;"></div>
        <div v-html="content" style="font-weight:300;width:616px;margin:0 auto;margin-bottom: 10px;"></div>
        <div style="width:616px;margin:0 auto;border-top:1px dashed #e0e0e0;margin-top:10px;margin-bottom:10px;"></div>
        <div style="height:70px;line-height:55px;width:616px;margin:0 auto;font-weight:300;text-align: center;">
            <el-button @click="addZan()" type="primary" :disabled="dianzan">点赞({{ zan }})</el-button>
        </div>
        <div style="width:100%;background:white;float:left;margin-bottom:10px;margin-top:10px;">
            <div style="width:616px;margin: 0 auto;height:40px;line-height:45px;">
                <a v-if="lastBlogName" style="cursor: pointer;" @click="lastBlogMethod()">上一篇：{{ lastBlogName }}</a>
                <a v-else>上一篇：没有了</a>
            </div>
            <div style="width:616px;margin: 0 auto;height:40px;line-height:30px;">
                <a v-if="nextBlogName" style="cursor: pointer;" @click="nextBlogMethod()">下一篇：{{ nextBlogName }}</a>
                <a v-else>下一篇：没有了</a>
            </div>
        </div>
        <div style="width: 100%;background:white;float: left;">
            <div
                style="margin-bottom:10px;margin-top:10px;float:left;width:97%;margin-left:1.5%;font-size:19px;height:30px;line-height:20px;border-bottom:1px solid #DCDFE6;">
                <div style="margin-left:10px;margin-right:10px;">评论</div>
            </div>
            <el-input disabled style="width:97%;margin-left:1.5%;" type="textarea" v-model="message.content" :rows="5"
                placeholder="请输入评论内容"></el-input>
            <div style="float:left;width:97%;margin-left:1.5%;margin-top: 10px;margin-bottom: 10px;">
                <el-input disabled style="float:left;width:260px;" placeholder="请输入昵称" v-model="message.name"></el-input>
                <el-input disabled style="float:left;width:340px;margin-left: 20px;" placeholder="请输入邮箱，非必填"
                    v-model="message.email"></el-input>
                <el-button :disabled="true" style="margin-left: 20px;float:right;" type="primary">发表评论</el-button>
            </div>
            <div style="border-top:2px solid #1abc9c;height: 10px;width: 100%;float: left;"></div>
            <div style="border-bottom:1px solid #DCDFE6;float:left;width:100%;margin-bottom: 10px;background: white;"
                v-for="item in tableData">
                <div style="float:left;height: 70px;width: 90px;">
                    <img src="../../../static/images/user.jpg"
                        style="height:70px;width:70px;margin-left:10px;margin-top:10px;" />
                </div>
                <div style="float:left;width: 680px;">
                    <div style="width:100%;height: 15px;margin-top:10px;font-weight: 600;font-size: 13px;">
                        {{ item.name }}
                    </div>
                    <div style="width:100%;height: 20px;line-height: 20px;font-size: 12px;">
                        {{ item.createtime }}
                    </div>
                    <div style="margin-bottom: 5px;width:100%;min-height: 50px;font-size: 14px;line-height: 20px;">
                        {{ item.content }}
                    </div>
                </div>
            </div>
            <div v-if="tableData.length == 0"
                style="text-align:center;height:50px;line-height:50px;width:100%;background:white;float:left;margin-bottom:10px;">
                评论区暂无评论，来抢个沙发吧~
            </div>
        </div>
    </div>
</template>
<script>
import { Message } from "element-ui";
import global from '../data/data.js';
export default {
    data() {
        return {
            id: this.$route.query.id,
            lastBlog: "",
            nextBlog: "",
            lastBlogName: "",
            nextBlogName: "",
            content: "",
            title: "",
            zan: 0,
            dianzan: false,
            message: {
                parentid: "",
                content: "",
                name: "",
                email: ""
            },
            tableData: [],
        };
    },
    methods: {
        getBlogById() {
            var blog = {};
            for (var i = 0; i < global.allBlog.length; i++) {
                if (this.id == global.allBlog[i].id) {
                    blog = global.allBlog[i];
                    break;
                }
            }
            this.content = blog.content;
            this.title = blog.title;
            this.lastBlog = blog.lastBlog;
            this.nextBlog = blog.nextBlog;
            this.lastBlogName = blog.lastBlogName;
            this.nextBlogName = blog.nextBlogName;
            this.zan = blog.zan;
            document.documentElement.scrollTop = 0;
        },
        nextBlogMethod() {
            const routeData = this.$router.resolve({
                path: '/content',
                query: {
                    id: this.nextBlog
                }
            });
            window.open(routeData.href, "_blank");
        },
        lastBlogMethod() {
            const routeData = this.$router.resolve({
                path: '/content',
                query: {
                    id: this.lastBlog
                }
            });
            window.open(routeData.href, "_blank");
        },
        addZan() {
            this.zan++;
            this.dianzan = true;
            Message.success({ message: "点赞成功，感谢您的支持！" });
        }
    },
    mounted() {
        this.getBlogById();
    }
}
</script>
<style></style>