<template>
	<div>
		<h1>门诊科室工作量统计</h1>
		<p v-text="msg" style="color: red;"></p ><br><br />
		<el-form class="my-form" style="width: 96%; margin: 0 auto;">
			
			
			<el-form-item label="统计日期">
			<el-input  type="text" v-model="workloadstatistics.startTime"></el-input>至
			<el-input  type="text" v-model="workloadstatistics.endTime"></el-input>
			
			</el-form-item> 
			<el-form-item label="科室分类">
			<el-input  type="text" v-model="workloadstatistics.deptName"></el-input>
			
			
			</el-form-item> 
			<el-button type="primary" class="btn-center" @click='doSelectAll()'>查询</el-button>
			
			<br />
			<el-table :data="list" stripe border class="el-table" style="width: 96%;margin: 0 auto;">
				<el-table-column prop="id" label="编号" sortable></el-table-column>
				<el-table-column prop="name" label="项目名称" sortable></el-table-column>
				<el-table-column prop="price" label="项目单价"></el-table-column>
				<el-table-column prop="amount" label="数量"></el-table-column>
				<el-table-column prop="deptID" label="执行科室id "></el-table-column>
				<el-table-column prop="deptName" label="科室名称 "></el-table-column>
				<el-table-column prop="deptType" label="科室类型"></el-table-column>
				
				<el-table-column prop="revenue" label="单项项目金额"></el-table-column>
			
				</el-table>
				
			
				
			</el-form>	
			</div>
			
</template>
<script setup>
	
	import {
		ref,
		inject,
		provide
	} from 'vue'
	const axios = inject('axios');
	const qs = inject('qs');
	import {
		useRouter
	} from 'vue-router'
	const router = useRouter();
	
	
	const workloadstatistics = ref({
		
		deptName:'心血管内科',
		startTime:'2019-04-01T00:00',
		endTime:'2019-04-02T00:00'
	})
	const msg = ref('');
	const list = ref([]); //查询结果
	
	const doSelectAll = () => {
		let url = '/outpatientworkload/selectWorkloadStatistics';
		
		axios.post(url, qs.stringify(workloadstatistics.value))
			.then((resp) => {
				if(workloadstatistics.startTime > workloadstatistics.endTime){
					msg.value='输入日期错误'
				}
				let data=resp.data;
				console.log('result:',data);
				list.value =data;
			})
			.catch((err)=>{
				console.log('err=', err);
			});
	}
	
	
	
</script>

<style>
</style>
