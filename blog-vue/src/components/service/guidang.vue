<template>
    <div style="background:white;">
        <div class="block">
            <div style="height:10px;width:100%;"></div>
            <el-timeline>
                <el-timeline-item v-for="item in blogList" v-bind:key="item.id" :timestamp="item.createtime"
                    placement="top">
                    <div style="margin-right:50px;line-height:50px;border-bottom:1px dashed #e0e0e0;">
                        <a @click="content(item.id)" style="cursor: pointer;">{{ item.title }}</a>
                    </div>
                </el-timeline-item>
            </el-timeline>
        </div>
    </div>
</template>
<script>
import global from '../data/data.js';
export default {
    data() {
        return {
            blogList: []
        };
    },
    methods: {
        getData() {
            this.blogList = global.allBlog;
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
        this.getData();
    }
}
</script>
<style></style>