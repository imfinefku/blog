<template>
    <div style="width: 100%;background:white;float: left;">
        <div
            style="margin-bottom:10px;margin-top:10px;float:left;width:97%;margin-left:1.5%;font-size:19px;height:30px;line-height:20px;border-bottom:1px solid #DCDFE6;">
            <div style="margin-left:10px;margin-right:10px;">留言板</div>
        </div>
        <el-input disabled style="width:97%;margin-left:1.5%;" type="textarea" v-model="message.content" :rows="5"
            placeholder="请输入留言内容"></el-input>
        <div style="float:left;width:97%;margin-left:1.5%;margin-top: 10px;margin-bottom: 10px;">
            <el-input disabled style="float:left;width:260px;" placeholder="请输入昵称" v-model="message.name"></el-input>
            <el-input disabled style="float:left;width:340px;margin-left: 20px;" placeholder="请输入邮箱，非必填"
                v-model="message.email"></el-input>
            <el-button :disabled="true" style="margin-left: 20px;float:right;" type="primary">发表留言</el-button>
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
    </div>
</template>
<script>
import formatDate from '../../utils/dateUtil.js';
export default {
    data() {
        return {
            message: {
                content: "",
                name: "",
                email: ""
            },
            tableData: [
                {
                    "name": "Java十点半",
                    "content": "源码、论文（包查重，提供查重报告）、答辩ppt、讲解，一条龙服务。",
                    "createtime": "2023-06-20 17:20:32"
                },
                {
                    "name": "Java十点半",
                    "content": "大家有做毕设需求可以找我",
                    "createtime": "2023-06-15 18:10:20"
                },
                {
                    "name": "Java十点半",
                    "content": "留言板和博客留言暂时关闭~",
                    "createtime": "2023-06-07 15:44:34"
                }
            ],
        };
    },
    methods: {
        getMessagePage() {
            that.tableData = response.data.data;
            that.total = response.data.count;
            for (var i = 0; i < that.tableData.length; i++) {
                that.tableData[i].createtime = formatDate(new Date(that.tableData[i].createtime), 'yyyy-MM-dd hh:mm:ss');
            }
            if (response.data.count / that.pageSize > parseInt(response.data.count / that.pageSize)) {
                that.totalPage = parseInt(response.data.count / that.pageSize) + 1;
            } else {
                that.totalPage = parseInt(response.data.count / that.pageSize);
            }
        }
    },
    mounted() {
        this.getMessagePage();
    }
}
</script>
<style></style>