<template>
	<div>
		<h1>门诊日结核对</h1>
		<p v-text="msg" style="color: red;"></p ><br><br />
	
		<el-form class="my-form" style="width: 96%; margin: 0 auto;">
			<el-form-item label="收费员">
				<el-input  type="text" v-model="outpatientfinance.userName"></el-input>
				
			</el-form-item> 
			<el-form-item label="统计日期">
				<el-input  type="text" v-model="outpatientfinance.creationTime"></el-input>
				
			</el-form-item>
			<el-button type="primary" class="btn-center" @click='doSelectAll()'>查询</el-button>
			
			
			<br />
			<el-table :data="list" stripe border class="el-table" style="width: 96%;margin: 0 auto;">
				<el-table-column prop="id" label="编号" sortable></el-table-column>
				<el-table-column prop="invoiceNum" label="发票号码" sortable></el-table-column>
				<el-table-column prop="money" label="发票金额"></el-table-column>
				<el-table-column prop="state" label="发票状态"></el-table-column>
				<el-table-column prop="creationTime" label="收/退费时间 "></el-table-column>
				<el-table-column prop="userID" label="收/退费人员ID "></el-table-column>
				<el-table-column prop="registID" label="挂号ID "></el-table-column>
				<el-table-column prop="feeType" label="收费方式 "></el-table-column>
				<el-table-column prop="back" label="冲红发票号码"></el-table-column>
				<el-table-column prop="dailyState" label="发票日结状态"></el-table-column>
			
				
	
			</el-table>
			<el-button type="info" class="btn-center" @click='doPass()'>核对通过</el-button>
			<el-button type="info" class="btn-center" @click='doReiterate()'>打回重申</el-button>
	
		</el-form>	
	
	</div>
</template>
<script setup>
	// 引入公共的模块及变量-基本是固定代码
	import {
		ref,
		inject,
		provide
	} from 'vue'
	const axios = inject('axios');
	const qs = inject('qs');
	import {
		useRouter,
		useRoute
	} from 'vue-router'
	const router = useRouter();
	
	
	
	
	
	
	const outpatientfinance = ref({
		creationTime: '',
		userName: ''
	})
	const msg = ref('');
	const list = ref([]); //表示查询结果
	
	const doSelectAll = () => {
		let url = '/outpatientfinance/selectAll';
		axios.post(url, qs.stringify(outpatientfinance.value))
			.then((resp) => {
				let data = resp.data;
				list.value = data;
				console.log(list.value);
			})
			.catch((err) => {
				console.log('err=', err);
			});
	}
	
	const doPass = () => {
			console.log("list:",list.value[1].userID);
			let backlist = ref([])
			for(var j = 0; j<list.value.length;j++){
				backlist.value[j] = list.value[j].userID;
			}
			console.log("backlist:" , backlist.value[0]);
			let url = '/outpatientfinance/pass';
			for(var i=0; i<backlist.value.length;i++){
				axios.post(url, "UserID="+backlist.value[i])
					.then((resp) => {
						let data = resp.data;
						if (data > 0) {
							msg.value = 'update ok'
							location.reload()
						} else {
							msg.value = '修改失败，请联系管理员处理！'
						}
					})
					.catch((err) => {
						console.log('err=', err);
					});
			}
			
		}


	const doReiterate = () => {
			console.log("list:",list.value[1].userID);
			let backlist = ref([])
			for(var j = 0; j<list.value.length;j++){
				backlist.value[j] = list.value[j].userID;
			}
			console.log("backlist:" , backlist.value[0]);
			let url = '/outpatientfinance/pass';
			for(var i=0; i<backlist.value.length;i++){
				axios.post(url, "UserID="+backlist.value[i])
					.then((resp) => {
						let data = resp.data;
						if (data > 0) {
							msg.value = 'update ok'
							location.reload()
						} else {
							msg.value = '修改失败，请联系管理员处理！'
						}
					})
					
					.catch((err) => {
						console.log('err=', err);
					});
			}
			
		}

	

</script>

<style>
</style>