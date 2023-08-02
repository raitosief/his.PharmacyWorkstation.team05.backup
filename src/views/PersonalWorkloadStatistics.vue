<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">

				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;"><br />
					<el-link type="info" style=" color: #F2F3F5;" @click='toDiagnosisCompleted()'>病历首页 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toInspectionApplication()'>检查申请 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toOutpatientDiagnosis()'>门诊确诊 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style="  color: #F2F3F5;" @click='toPatentPrescription()'>成药处方 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toDiagnosisCompleted()'>诊毕 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='toPersonalWorkloadStatistics()'>个人工作量统计 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="danger" style=" color: #F2F3F5;" @click='back()'>退出登录</el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-main>
					<span class="demonstration"></span>
					<el-date-picker v-model="timeform.StartTime" type="datetime" placeholder="选择起始时间" :shortcuts="shortcuts" />
					&nbsp;&nbsp;&nbsp;&nbsp;
					<el-date-picker v-model="timeform.EndTime" type="datetime" placeholder="选择结束时间" :shortcuts="shortcuts" />
					<br /><br /><br />
					<el-button type="primary" @click='doSelect()'>查询</el-button>

					<el-form style="width: 20%;margin-left: 40%;margin-top: 2%;">
						<el-form-item label="总患者人数" >
							<el-input v-model="totalNum" :disabled="true"></el-input>
						</el-form-item>
						<el-form-item label="总金额" style="margin-right: 30px;">
							<el-input v-model="totalCost" :disabled="true"></el-input>
						</el-form-item>
					</el-form><br>
					<el-table :data="checkList" stripe border class="el-table" style="width: 80%; margin: auto; align-items: center;">
						<el-table-column prop="registID" label="病历号" sortable width="200"></el-table-column>
						<el-table-column prop="registerName" label="姓名" sortable width="200"></el-table-column>
						<el-table-column prop="creationTime" label="开立时间" sortable width="250"></el-table-column>
						<el-table-column prop="name" label="项目名称" sortable width="200"></el-table-column>
						<el-table-column prop="isUrgent" label="是否紧急" sortable width="200"></el-table-column>
						<el-table-column prop="totalCost" label="花费总金额" sortable width="200"></el-table-column>
					</el-table>
				</el-main>
			</el-container>
		</el-container>
	</div>
</template>

<script setup>
	import axios from 'axios'
	import qs from 'qs'
	import {
		useRouter
	} from 'vue-router'
	import {
		ref,
		inject
	} from 'vue';
	const router = useRouter();

	const timeform = ref({
		StartTime:'',
		EndTime: ''
	})
	
	const checkList = ref([]);
	const totalNum = ref(0);
	const totalCost = ref(0);
	// 六个模块路由跳转
	const toDiagnosisCompleted = () => {
		router.push({
			path: '/DiagnosisCompleted',
		});
	}
	const toPersonalWorkloadStatistics = () => {
		router.push({
			path: '/PersonalWorkloadStatistics',
		})
	}
	const toOutpatientDiagnosis = () => {
		router.push({
			path: '/OutpatientDiagnosis',
		})
	}
	const toInspectionApplication = () => {
		router.push({
			path: '/InspectionApplication',
		})
	}
	const toPatentPrescription = () => {
		router.push({
			path: '/PatentPrescription',
		})
	}
	
	const back = () =>{
		router.push({
			path:'/index',
		})
	}
	// const tofinance = () => {
	// 	router.push('')
	// }
	const shortcuts = [{
			text: 'Today',
			value: new Date(),
		},
		{
			text: 'Yesterday',
			value: () => {
				const date = new Date()
				date.setTime(date.getTime() - 3600 * 1000 * 24)
				return date
			},
		},
		{
			text: 'A week ago',
			value: () => {
				const date = new Date()
				date.setTime(date.getTime() - 3600 * 1000 * 24 * 7)
				return date
			},
		},
	]


	// 查询方法，名字可以改
	const doSelect = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/personalWorkloadStatistics/selectByID';
		totalCost.value = 0;
		totalNum.value = 0;
		console.log(timeform.value.StartTime);
		console.log(timeform.value.EndTime);
		axios.post(url, qs.stringify(timeform.value))
			.then((resp) => {
				let data = resp.data.data;
				console.log(data);
				data.forEach(item=>{
					let a = item.creationTime;
					item.creationTime = a.substring(0, 10)+" " +a.substring(11,19);
					totalNum.value += 1;
					totalCost.value += item.totalCost;
				})
				checkList.value = data;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}
</script>

<style scoped="scoped">
	.common-layout {
		width: 100%;
		height: 100%;
		display: flex;
		flex-direction: column;
	}

header {
		height: 60px;
		width: 100%;
		background-image: url(../assets/logo.jpg);
		background-size: 100% 100%;
	}
	
	main {
		width: 100%;
		background-image: url(../assets/main.jpg);
		background-size: 120% 100%;
	}

</style>
