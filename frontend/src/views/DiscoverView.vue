<script setup lang="ts">
import FooterSection from '@/components/FooterSection.vue';
</script>

<template>
  <div class="wrapper">
    <i class="fa fa-wheelchair-alt" aria-hidden="true"></i>
    <!-- 底部菜单部分 -->
    <FooterSection />
  </div>
</template>

<style scoped>
/****总容器部分***/
.wrapper {
  width: 100%;
  height: 100%;
  background-color: #eee;
  text-align: center;
  display: flex;
  justify-content: center;
}

/****header部分***/
.wrapper header {
  width: 100%;
  height: 18vw;
  background-color: #fffff3;

  display: flex;
  align-items: center;
}
.wrapper .fa-wheelchair-alt {
  margin: auto;
  font-size: 50vw;
  vertical-align: middle;
}
</style>
