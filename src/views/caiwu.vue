<template>
		<div class="main">
			<div class="left">
				欢迎进入财务管理模块
				<br /><br />
	
				<h4>财务管理</h4>
				&nbsp;&nbsp;&nbsp;&nbsp;<router-link to="/expenseclass/ExpQuery">费用科目管理</router-link><br />
				&nbsp;&nbsp;&nbsp;&nbsp;<router-link to="/outpatientFinance/InvoiceQuery">门诊日结核对</router-link><br />
				&nbsp;&nbsp;&nbsp;&nbsp;<router-link to="/outpatientdepartmentworkloadstatistics/WorkloadStatisticsQuery">门诊科室工作量统计</router-link><br />
				</div>
		
			<div class="right">
				<router-view></router-view>
			</div>
		</div>
	
</template>

<script setup>
	import axios from 'axios'
	import {useRouter} from 'vue-router'
	const router = useRouter();
	

</script>

<style scoped="scoped">
	.main {
		width: 100%;
		height: 100%;
		display: flex;
	}
	
	.left {
		width: 150px;
		height: 100%;
		background-color: lightcyan;
	}
	
	.right {
		width: 100%;
		height: 100%;
		background-color: lightgray;
	}
</style>