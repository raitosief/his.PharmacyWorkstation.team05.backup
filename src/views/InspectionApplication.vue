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
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div class="bg"></div>
					<br /><br /><br />
					<div class="content">
						<el-form-item label="患者姓名" style="width: 260px;">
							<el-input type="text" v-model="searchRegister.realName" placeholder="请输入患者姓名"></el-input>
						</el-form-item><br>
						<el-form-item label="病历单号" style="width: 260px;">
							<el-input type="text" v-model="searchRegister.caseNumber" placeholder="请输入患者病历单号"></el-input>
						</el-form-item><br>
						<el-form-item style="margin-left: 35%;">
							<el-button type="primary" class="btn-center" @click='doselect()'>查询</el-button>
						</el-form-item>
						<el-table :data="listAside" stripe border class="el-table" style="width: 96%; margin: auto; align-items: center;">
							<el-table-column prop="caseNumber" label="病历号" sortable width="100"></el-table-column>
							<el-table-column prop="realName" label="姓名" sortable width="100"></el-table-column>
							<el-table-column fixed="right" label="操作" width="90">
								<template #default="scope">
									<el-button type="info" @click='show(scope.$index)'>查看</el-button>
								</template>
							</el-table-column>
						</el-table>
					</div>
				</el-aside>
				<el-container>
					<el-main>

						<div>
							<h2 style="color: #3375B9;">检查项目</h2>
							<el-table :data="checkList" stripe border class="el-table" style="width: 96%; height: 350px; margin: auto; align-items: center;">
								<el-table-column fixed="left" prop="itemName" label="项目名称" sortable width="200"></el-table-column>
								<el-table-column prop="itemID" label="项目ID" sortable width="200"></el-table-column>
								<el-table-column prop="medicalID" label="病历ID" sortable width="200"></el-table-column>
								<el-table-column prop="objective" label="目的要求" sortable width="200"></el-table-column>
								<el-table-column prop="position" label="检查部位" sortable width="200"></el-table-column>
								<el-table-column prop="isUrgent" label="是否加急" sortable width="200"></el-table-column>
								<el-table-column prop="result" label="检查结果" sortable width="200"></el-table-column>
								<el-table-column prop="state" label="状态" sortable width="200"></el-table-column>
								<el-table-column fixed="right" label="操作" width="275px">
									<template #default="scope">
										<el-button style="size:mini; height: 30px; width: 40px;" type="primary" @click='Staging(scope.$index)'>暂存</el-button>
										<el-button style="size:mini; height: 30px; width: 40px;" type="primary" @click='open(scope.$index)'>开立</el-button>
										<el-button style="size:mini; height: 30px; width: 40px;" type="primary" @click='getresult(scope.$index)'>结果</el-button>
										<el-button style="size:mini; height: 30px; width: 40px;" type="danger" @click='dodelete(scope.$index)'>删除</el-button>
										<el-button style="size:mini; height: 30px; width: 40px;" type="danger" @click='repeal(scope.$index)'>作废</el-button>
									</template>
								</el-table-column>
							</el-table>
						</div><br /><br />

						<el-form style="width: 80%;margin-left: 10%;">
							<el-row>
								<el-col :span="8">
									<el-form-item label="项目名称" style="margin-right: 30px;">
										<el-input v-model="newcheck.ItemName" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="目的要求" style="margin-right: 30px;">
										<el-input v-model="newcheck.Objective" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="检查部位" style="margin-right: 30px;">
										<el-input v-model="newcheck.Position" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row>
								<el-col :span="8">
									<el-form-item label="是否加急" style="margin-right: 30px;">
										<el-radio-group v-model="newcheck.IsUrgent" class="ml-4" style="color: #1F4FA3;">
											<el-radio label="1" size="large">是</el-radio>
											<el-radio label="0" size="large">否</el-radio>
										</el-radio-group>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="数量" style="margin-right: 30px;">
										<el-input-number v-model="newcheck.Num" :min="1" :max="5" />
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="开立时间" style="margin-right: 30px;">
										<el-date-picker v-model="newcheck.CreationTime" type="datetime" placeholder="请选择开立时间" :shortcuts="shortcuts" />
									</el-form-item>
								</el-col>
							</el-row>
						</el-form>
						<el-button type="primary" @click='add()'>添加</el-button>
					</el-main>
				</el-container>
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

	const searchRegister = ref({
		DeptID: '1',
		UserID: '1',
	});


	const checkList = ref([]);
	const listAside = ref([]);
	const newcheck = ref({
		MedicalID:'',
		RegistID:'',
		ItemName: '',
		Objective: '',
		Pisition: '',
		IsUrgent: '',
		Num: '',
		CreationTime: '',
		RegistID: ''
	});
	const index = ref('');
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

	const doselect = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/select';
		axios.post(url, qs.stringify(searchRegister.value))
			.then((resp) => {
				let data = resp.data.data;
				listAside.value = data;
				console.log(listAside.value);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const show = (i) => {
		// index.value = i;
		newcheck.value.RegistID = listAside.value[i].id; 
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/getCheck';
		axios.post(url, 'ID=' + listAside.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				checkList.value = data;
				console.log(data);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}
	
	const add = () =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/addCheck';
		// console.log(listAside.value[i].id);
		axios.post(url, qs.stringify(newcheck.value))
			.then((resp) => {
				let data = resp.data.data;
				if(data == 0){
					alert('没有该项目');
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		// show(index);
	}
	
	const Staging = (i) =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/staging';
		// console.log(checkList.value[i]);
		axios.post(url, "ID="+ checkList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if(data == 0){
					alert('状态不符合');
				}else{
					checkList.value[i].state = '1';
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}
	
	const open = (i) =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/open';
		// console.log(checkList.value[i]);
		axios.post(url, "ID="+ checkList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if(data == 0){
					alert('状态不符合');
				}
				else{
					checkList.value[i].state = '2';
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		
	}
	
	const repeal = (i) =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/repeal';
		axios.post(url, "ID="+ checkList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if(data == 0){
					alert('状态不符合');
				}
				else{
					checkList.value[i].state = '0';
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		
	}
	
	const dodelete = (i) =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/dodelete';
		axios.post(url, "ID="+ checkList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if(data == 0){
					alert('状态不符合');
				}
				else{
					checkList.value.splice(i,1);
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		
	}
	
	const getresult = (i) =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/inspectionApplication/getresult';
		axios.post(url, "ID="+ checkList.value[i].id)
			.then((resp) => {
				let data = resp.data.data;
				if(data == null){
					alert('状态不符合');
				}
				else{
					checkList.value[i].result = data;
					console.log(data);
				}
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		
	}
	
	
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
	
	aside {
		width: 350px;
		position: relative;
	
	}
	
	.bg {
		background-image: url(../assets/aside.jpg);
		height: 100%;
		width: 100%;
		float: left;
		background-size: cover;
		filter: blur(8px);
	}

	.content {
		margin-left: 13%;
		position: absolute;
	}
</style>
