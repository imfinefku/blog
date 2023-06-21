<template>
    <div>
        <div
            style="width:100%;height:100px;text-align:center;line-height:100px;background:white;font-size: 25px;margin-bottom: 15px;">
            包含关键词"{{ keyword }}"的博客</div>
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
        <div v-if="tableData.length == 0"
            style="height:50px;line-height:50px;width:100%;background:white;float:left;margin-bottom:15px;">
            <div style="margin-left:20px;">暂无相关博客</div>
        </div>
    </div>
</template>
<script>
import global from '../data/data.js';
export default {
    data() {
        return {
            tableData: [],
            keyword: this.$route.query.keyword
        };
    },
    methods: {
        getDataPage() {
            var temp = [];
            for (var i=0;i<global.allBlog.length;i++){
                if (global.allBlog[i].title.search(this.keyword)!=-1){
                    temp.push(global.allBlog[i]);
                }else if (global.allBlog[i].introduce.search(this.keyword)!=-1){
                    temp.push(global.allBlog[i]);
                }
            }
            this.tableData = temp;
            document.documentElement.scrollTop = 0;
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
        this.getDataPage();
    },
    watch: {
        $route() {
            this.keyword = this.$route.query.keyword;
            this.getDataPage();
        }
    }
}
</script>
<style>
body {
    margin: 0 auto;
}
</style>