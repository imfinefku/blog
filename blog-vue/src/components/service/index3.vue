<template>
    <div>
        <el-carousel v-if="lunbo.length > 0" :interval="4000" height="300px" style="background:white;margin-bottom: 15px;">
            <el-carousel-item v-for="item in lunbo" :key="item.id">
                <img :src="item.image" @click="content(item.id)" style="cursor: pointer;height:300px;width:100%;" />
            </el-carousel-item>
        </el-carousel>
        <div v-for="item in tableData" v-bind:key="item.id"
            style="font-weight:300;line-height:30px;float:left;background: white;width: 100%;margin-bottom: 15px;">
            <div style="height: 50px;width:100%;"></div>
            <div style="font-size:20px;width: 616px;cursor: pointer;margin:0 auto;" @click="content(item.id)">
                {{ item.title }}
            </div>
            <div style="width: 616px;margin:0 auto;border-top:1px dashed #e0e0e0;margin-top:10px;margin-bottom:10px;">
            </div>
            <div v-if="item.image" style="width: 616px;margin:0 auto;">
                <img @click="content(item.id)" :src="item.image"
                    style="cursor: pointer;width:170px;height:100px;float:left;margin-top:10px;margin-right:10px;" />
                <div style="cursor: pointer;min-height: 120px;" v-html="item.introduce" @click="content(item.id)">
                </div>
            </div>
            <div v-else style="width: 616px;margin:0 auto;">
                <div style="cursor: pointer;" v-html="item.introduce" @click="content(item.id)"></div>
            </div>
            <div style="width: 616px;margin:0 auto;border-top:1px dashed #e0e0e0;margin-top:10px;margin-bottom:10px;">
            </div>
            <div style="width: 616px;margin:0 auto;font-size: 14px;">
                <div style="float:left;margin-top:1px;margin-right: 3px;">
                    <img style="height:14px;width:14px;" src="../../../static/images/tag.png" />
                </div>
                <div style="float:left;">{{ item.tagname }}</div>
                <div style="float:left;margin-top:1px;margin-right: 3px;margin-left: 30px;">
                    <img style="height:15px;width:14px;" src="../../../static/images/time.png" />
                </div>
                <div style="float:left;">{{ item.createtime }}</div>
                <div style="float:left;margin-top:3px;margin-right: 3px;margin-left: 30px;">
                    <img style="height:18px;width:16px;" src="../../../static/images/look.png" />
                </div>
                <div style="float:left;">{{ item.look }}</div>
                <div style="float:left;margin-top:3px;margin-right: 3px;margin-left: 30px;">
                    <img style="height:17px;width:16px;" src="../../../static/images/good.png" />
                </div>
                <div style="float:left;">{{ item.zan }}</div>
            </div>
            <div style="height: 50px;width:100%;float:left;"></div>
        </div>
        <div style="width:100%;background:white;float:left;margin-bottom:15px;">
            <el-button v-if="lastShow" size="medium"
                style="float:left;margin-left:15px;margin-top: 15px;margin-bottom: 15px;"
                @click="lastPage()">上一页</el-button>
            <el-button v-if="nextShow" size="medium"
                style="float:right;margin-right:15px;margin-top: 15px;margin-bottom: 15px;"
                @click="nextPage()">下一页</el-button>
        </div>
    </div>
</template>
<script>
import global from '../data/data.js';
export default {
    data() {
        return {
            pageSize: 100,
            currentPage: 1,
            totalPage: 1,
            tableData: [],
            lastShow: true,
            nextShow: true,
            lunbo: []
        };
    },
    methods: {
        getDataPage(currentPage, pageSize) {
            if (global.allBlog.length / this.pageSize > parseInt(global.allBlog.length / this.pageSize)) {
                this.totalPage = parseInt(global.allBlog.length / this.pageSize) + 1;
            } else {
                this.totalPage = parseInt(global.allBlog.length / this.pageSize);
            }
            var tempBlogData = [];
            var start = currentPage*pageSize-pageSize;
            var end=start+pageSize;
            if (currentPage==this.totalPage){
                end=global.allBlog.length;
            }
            for (var i=start;i<end;i++){
                tempBlogData.push(global.allBlog[i]);
            }
            this.tableData = tempBlogData;
            if (this.currentPage == this.totalPage) {
                this.nextShow = false;
            } else {
                this.nextShow = true;
            }
            if (this.currentPage == 1) {
                this.lastShow = false;
            } else {
                this.lastShow = true;
            }
            document.documentElement.scrollTop = 0;
        },
        getLunBo() {
            var temp = [];
            for (var i = 0; i < global.allBlog.length; i++) {
                if (global.allBlog[i].lunbo) {
                    temp.push(global.allBlog[i]);
                }
            }
            this.lunbo = temp;
        },
        content(id) {
            const routeData = this.$router.resolve({
                path: '/content',
                query: {
                    id: id
                }
            });
            window.open(routeData.href, "_blank");
        },
        nextPage() {
            if (this.currentPage < this.totalPage) {
                this.currentPage++;
                this.getDataPage(this.currentPage, this.pageSize);
            }
        },
        lastPage() {
            if (this.currentPage > 1) {
                this.currentPage--;
                this.getDataPage(this.currentPage, this.pageSize);
            }
        }
    },
    mounted() {
        this.getDataPage(this.currentPage, this.pageSize);
        this.getLunBo();
    }
}
</script>
<style>
body {
    margin: 0 auto;
}
</style>