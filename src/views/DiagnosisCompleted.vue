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
							<el-input type="text" v-model="searchRegister.realName"></el-input>
						</el-form-item><br>
						<el-form-item label="病历单号" style="width: 260px;">
							<el-input type="text" v-model="searchRegister.caseNumber"></el-input>
						</el-form-item><br>
						<el-form-item>
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
						<el-form style="width: 80%;margin-left: 10%;margin-top: 5%;">
							<el-row>
								<el-col :span="8">
									<el-form-item label="病历号" style="margin-right: 30px;">
										<el-input v-model="register.caseNumber" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="姓名" style="margin-right: 30px;">
										<el-input v-model="register.realName" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="年龄" style="margin-right: 30px;">
										<el-input v-model="register.age" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row><br />
							<el-row>
								<el-col :span="8">
									<el-form-item label="性别" style="margin-right: 30px;">
										<el-input v-model="register.gender" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="看诊日期" style="margin-right: 30px;">
										<el-input v-model="register.visitDate" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="挂号时间" style="margin-right: 30px;">
										<el-input v-model="register.registTime" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row><br />
							<el-row>
								<el-col :span="8">
									<el-form-item label="挂号科室" style="margin-right: 30px;">
										<el-input v-model="register.deptID" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="挂号医生" style="margin-right: 30px;">
										<el-input v-model="register.userID" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="挂号级别" style="margin-right: 30px;">
										<el-input v-model="register.registLeID" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row><br />

							<el-row>
								<el-col :span="8">
									<el-form-item label="午别" style="margin-right: 30px;">
										<el-input v-model="register.noon" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="看诊状态" style="margin-right: 30px;">
										<el-input v-model="register.visitState" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="病历本要否" style="margin-right: 30px;">
										<el-input v-model="register.isBook" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row>

						</el-form>
						<br><br><br>
						<el-button type="primary" @click='over()'>诊毕</el-button>
						<el-button type="primary" @click='refresh()'>刷新</el-button>
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

	const listAside = ref([{
		ID: '', // ID 自增长类型
		CaseNumber: '', // 病历号
		RealName: '', // 姓名
		Gender: '', // 性别
		IDnumber: '', // 身份证号
		BirthDate: '', // 出生日期
		Age: '', // 年龄
		AgeType: '', // 年龄类型 岁/月/天
		HomeAddress: '', // 家庭住址
		VisitDate: '', // 本次看诊日期
		Noon: '', // 午别 上午/下午
		DeptID: '', // 本次挂号科室ID 指向 Department( ID )
		UserID: '', // 本次挂号医生ID 指向 User (ID)
		RegistLeID: '', // 本次挂号级别ID 指向 RegistLevel(ID)
		SettleID: '', // 结算类别 ID 指向SettleCategory(ID)
		IsBook: '', // 病历本要否 是/否
		RegistTime: '', // 挂号时间
		RegisterID: '', // 挂号员 ID 指向 User(ID)
		VisitState: '', // 本次看诊状态 1-已挂号 2-医生接诊 3-看诊结束 4-已退号
		StartTime: '',
		EndTime: '',
	}]);
	const register = ref({});
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
		url = '/outpatientDoctorWorkStation/DiagnosisCompleted/select';
		axios.post(url, qs.stringify(searchRegister.value))
			.then((resp) => {
				let data = resp.data.data;
				listAside.value = data;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const show = (i) => {
		register.value = listAside.value[i];
		console.log(register.value);
	}

	const over = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/DiagnosisCompleted/commitEndPatient';
		axios.post(url, qs.stringify(register.value))
			.then((resp) => {
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		url = '/outpatientDoctorWorkStation/DiagnosisCompleted/commitEndMedicalRecord';
		axios.post(url, qs.stringify(register.value))
			.then((resp) => {
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}
	
	const refresh =()=>{
		register.value = {};
		let url = '';
		url = '/outpatientDoctorWorkStation/DiagnosisCompleted/select';
		axios.post(url, qs.stringify(searchRegister.value))
			.then((resp) => {
				let data = resp.data.data;
				listAside.value = data;
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
