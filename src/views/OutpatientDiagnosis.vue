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
						<el-form style="width: 80%;margin-left: 10%;">
							<el-row>
								<el-col :span="8">
									<el-form-item label="病历号" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.CaseNumber" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="姓名" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.RealName" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="年龄" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Age" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row>
								<el-col :span="8">
									<el-form-item label="性别" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Gender" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="主诉" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Readme" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="现病史" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Present" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row>
								<el-col :span="8">
									<el-form-item label="现病治疗情况" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.PresentTreat" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="既往史" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.History" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="过敏史" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Allergy" :disabled="true"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row>
								<el-col :span="8">
									<el-form-item label="体格检查" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Physique" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="检察建议" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Proposal" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="注意事项" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Careful" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
							</el-row>
							<el-row>
								<el-col :span="8">
									<el-form-item label="检查结果" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.CheckResult" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="诊断结果" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Diagnosis" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
								<el-col :span="8">
									<el-form-item label="处理意见" style="margin-right: 30px;">
										<el-input v-model="medicalRecord.Handling" type="textarea" placeholder="请输入内容"></el-input>
									</el-form-item>
								</el-col>
							</el-row><br>
							<div style="display: flex;margin-left: 25%;">
								<el-button type="primary" @click='makeDiagnosis()'>确诊</el-button>
								<el-form-item label="模板名称" style="width: 260px; margin-left: 30px;" >
									<el-input type="text" v-model="template.TempName" placeholder="请输入模板名"></el-input>
								</el-form-item><br>
								<el-form-item>
									<el-button type="primary" class="btn-center" @click='addtemplate()' style="margin-left: 30px;">添加</el-button>
								</el-form-item>
							</div>
						</el-form>

						<div>
							<h2 style="color: #3375B9;">常用诊断</h2>
							<el-table :data="tempList" stripe border class="el-table" style="width: 96%; margin: auto; align-items: center;">
								<el-table-column prop="tempName" label="模板名称" sortable width="130"></el-table-column>
								<el-table-column prop="physique" label="体格检查" sortable width="200"></el-table-column>
								<el-table-column prop="proposal" label="检察建议" sortable width="200"></el-table-column>
								<el-table-column prop="careful" label="注意事项" sortable width="200"></el-table-column>
								<el-table-column prop="checkResult" label="检查结果" sortable width="200"></el-table-column>
								<el-table-column prop="diagnosis" label="诊断结果" sortable width="200"></el-table-column>
								<el-table-column prop="handling" label="处理意见" sortable width="200"></el-table-column>
								<el-table-column fixed="right" label="操作" width="160">
									<template #default="scope">
										<el-button type="info" @click='use(scope.$index)'>使用</el-button>
										<el-button type="danger" @click='dodelete(scope.$index)'>删除</el-button>
									</template>
								</el-table-column>
							</el-table>
						</div>


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

	const template = ref({
		ID: '',
		TempName:'',
		Physique:'',
		Proposal: '',
		Careful: '',
		CheckResult: '',
		Diagnosis: '',
		Handling: '',
		UserID:'1'
	})
	
	const medicalRecord = ref({
		RealName: '',
		CaseNumber: '',
		Gender: '',
		Age: '',
		Readme: '',
		Present: '',
		PresentTreat: '',
		History: '',
		Allergy: '',
		Physique: '',
		Proposal: '',
		Careful: '',
		CheckResult: '',
		Diagnosis: '',
		Handling: '',
		CaseState: 1,
	});

	const tempList = ref([]);
	const listAside = ref([]);

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

	const addtemplate = () =>{
		template.value.Physique = medicalRecord.value.Physique
		template.value.Proposal = medicalRecord.value.Proposal
		template.value.Careful = medicalRecord.value.Careful
		template.value.CheckResult = medicalRecord.value.CheckResult
		template.value.Diagnosis = medicalRecord.value.Diagnosis
		template.value.Handling = medicalRecord.value.Handling
		let url = '';
		url = '/outpatientDoctorWorkStation/outpatientDiagnosis/commitTemplate';
		axios.post(url, qs.stringify(template.value))
			.then((resp) => {
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const dodelete = (i) =>{
		let url = '';
		url = '/outpatientDoctorWorkStation/outpatientDiagnosis/deleteDiagnosisTemplate';
		console.log('tempList.value[i].id:',tempList.value[i].id);
		axios.post(url, 'id='+tempList.value[i].id)
			.then((resp) => {
				tempList.value.splice(i,1);
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}
	
	const doselect = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/outpatientDiagnosis/select';
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

	const use = (i) =>{
		medicalRecord.value.Physique = tempList.value[i].physique;
		medicalRecord.value.Proposal = tempList.value[i].proposal;
		medicalRecord.value.Careful = tempList.value[i].careful;
		medicalRecord.value.CheckResult = tempList.value[i].checkResult;
		medicalRecord.value.Diagnosis = tempList.value[i].diagnosis;
		medicalRecord.value.Handling = tempList.value[i].handling;
	}
	
	const show = (i) => {
		medicalRecord.value.RealName = listAside.value[i].realName;
		medicalRecord.value.Age = listAside.value[i].age;
		medicalRecord.value.CaseNumber = listAside.value[i].caseNumber;
		medicalRecord.value.Gender = listAside.value[i].gender;
		let url = '';
		url = '/outpatientDoctorWorkStation/outpatientDiagnosis/initRecord';
		axios.post(url, qs.stringify(medicalRecord.value))
			.then((resp) => {
				let data = resp.data.data;
				medicalRecord.value.Readme = data.readme;
				medicalRecord.value.Present = data.present;
				medicalRecord.value.PresentTreat = data.presentTreat;
				medicalRecord.value.History = data.history;
				medicalRecord.value.Allergy = data.allergy;
				medicalRecord.value.Physique = data.physique;
				medicalRecord.value.Proposal = data.proposal;
				medicalRecord.value.Careful = data.careful;
				medicalRecord.value.CheckResult = data.checkResult;
				medicalRecord.value.Diagnosis = data.diagnosis;
				medicalRecord.value.Handling = data.handling;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
		url = '/outpatientDoctorWorkStation/outpatientDiagnosis/getDiagnosisTemplate';
		axios.post(url)
			.then((resp) => {
				let data = resp.data.data;
				tempList.value = data;
			})
			.catch(
				(err) => {
					console.log('err=', err);
				});
	}

	const makeDiagnosis = () => {
		let url = '';
		url = '/outpatientDoctorWorkStation/outpatientDiagnosis/confirm';
		axios.post(url, qs.stringify(medicalRecord.value))
			.then((resp) => {})
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
