<template>
	<div class="common-layout">
		<el-container>
			<el-header style="border-bottom: 1px solid #bebebe;">
				
				<div class="my-top" style="float: right; vertical-align: bottom; margin-right: 10px;"><br />
					<el-link type="info" style=" color: #F2F3F5;" @click='toregister()'>挂号 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='todoc()'>门诊 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='totech()'>医技 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style="  color: #F2F3F5;" @click='todrug()'>药房 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="info" style=" color: #F2F3F5;" @click='tofinance()'>财务 </el-link>&nbsp;&nbsp;&nbsp;&nbsp;
					<el-link type="danger" style=" color: #F2F3F5;">退出 </el-link>&nbsp;
				</div>
			</el-header>
			<el-container>
				<el-aside style="border-right: 1px solid #aaaaaa;">
					<div class="bg"></div>
					<br /><br /><br />
					<div class="content">
						<el-link type="success" el-button @click="Reg()" style="font-size:x-large">挂号 </el-link><br /><br />
						<el-link type="success" el-button @click="Xixi()" style="font-size:x-large">收费 </el-link><br /><br />
						<el-link type="success" el-button @click="Back()" style="font-size:x-large">退号 </el-link><br />
					</div>
				</el-aside>
				<el-container>
					<el-main>
						<el-form class="my-query" style="width: 100%; align-items: center;">
							<el-form-item label="病例号">
								<el-input type="text" v-model="user.CaseNumber"></el-input>
							</el-form-item>
	
								&nbsp;&nbsp;&nbsp;&nbsp;
								&nbsp;&nbsp;&nbsp;&nbsp;
								<el-form-item>
									<el-button type="primary" class="btn-center" @click='query()'>查询</el-button>
								</el-form-item>
							
							<br />
							<el-table :data="tableData" stripe border class="el-table" height="250" style="width: 96%; margin: auto; align-items: center;">
								<el-table-column prop="id" label="编号" width="50" sortable></el-table-column>
								<el-table-column prop="caseNumber" label="病历号" width="100" sortable></el-table-column>
								<el-table-column prop="realName" label="真实姓名" width="200"></el-table-column>
								<el-table-column prop="gender" label="性别" :formatter="isGender" width="50"></el-table-column>
								<el-table-column prop="idnumber" label="身份证号" width="300"></el-table-column>
								<el-table-column prop="birthDate" label="出生日期" width="300"></el-table-column>
								<el-table-column prop="age" label="年龄" width="300"></el-table-column>
								<el-table-column prop="ageType" label="年龄类型" width="300"></el-table-column>
								<el-table-column prop="homeAddress" label="家庭住址" width="300"></el-table-column>
								<el-table-column prop="visitDate" label="本次看诊日期" width="300"></el-table-column>
								<el-table-column prop="noon" label="午别" width="300"></el-table-column>
								<el-table-column prop="deptID" label="本次挂号科室ID" width="300"></el-table-column>
								<el-table-column prop="userID" label="本次挂号医生ID" width="300"></el-table-column>
								<el-table-column prop="registLeID" label="本次挂号级别ID" width="300"></el-table-column>
								<el-table-column prop="settleID" label="结算类型ID" width="300"></el-table-column>
								<el-table-column prop="isBook" label="病历本要否" width="300"></el-table-column>
								<el-table-column prop="registTime" label="挂号时间" width="300"></el-table-column>
								<el-table-column prop="registerID" label="挂号员ID" width="300"></el-table-column>
								<el-table-column prop="visitState" label="本次看诊状态" width="300"></el-table-column>
								
							
								<!-- fixed 用来锁定列 -->
								<el-table-column fixed="right" label="操作" width="300">
									<template #default="scope">
										<el-button type="info" @click='getCharge(scope.row)'>显示账目</el-button>
										<el-button type="danger" @click='doCharge(scope.row)'>收费</el-button>
									</template>
								</el-table-column>
							</el-table>
						</el-form>
					</el-main>
					
					
					
			
					
					
					
				</el-container>
			</el-container>
		</el-container>
		<el-row :gutter="20">
		    <el-col :span="12">
		      <h1 style="margin-left: 40%">药品费账目</h1>
		      <hr>
		      <el-table
		          :data="drugs_list"
		          border
		          stripe
		          height="250">
		        <el-table-column
		            prop="drugsCode"
		            fixed
		            label="药品编号"
		            width="140">
		        </el-table-column>
		        <el-table-column
		            prop="drugsName"
		            fixed
		            label="药品名称"
		            width="120">
		        </el-table-column>
		        <el-table-column
		            prop="drugsFormat"
		            fixed
		            label="药品规格"
		            width="130">
		        </el-table-column>
		        <el-table-column
		            prop="manufacturer"
		            fixed
		            label="生产产家"
		            width="100">
		        </el-table-column>
		        <el-table-column
		            prop="drugsPrice"
		            fixed
		            label="药品单价(元)"
		            width="120">
		        </el-table-column>
		      </el-table>
		    </el-col>
		    <el-col :span="12">
		      <h1 style="margin-left: 40%">非药品费账目</h1>
		      <hr>
		      <el-table
		          :data="items_list"
		          border
		          stripe
		          height="250">
		        <el-table-column
		            prop="itemCode"
		            fixed
		            label="项目编号"
		            width="120">
		        </el-table-column>
		        <el-table-column
		            prop="itemName"
		            fixed
		            label="项目名称"
		            width="120">
		        </el-table-column>
		        <el-table-column
		            prop="format"
		            fixed
		            label="规格"
		            width="120">
		        </el-table-column>
		        <el-table-column
		            prop="recordType"
		            fixed
		            label="项目类型"
		            :formatter="recordType"
		            width="120">
		        </el-table-column>
		        <el-table-column
		            prop="price"
		            fixed
		            label="单价(元)"
		            width="120">
		        </el-table-column>
		      </el-table>
		    </el-col>
		  </el-row>
		
		
		<el-dialog
		    title="发票信息"
		    v-model="dialogInvoice"
		    width="45%"
		    center>
		  <el-form
		      ref="form"
		      v-model="invoiceInFormation"
		      label-width="150px">
		    <el-form-item label="发票编号:">
		      <el-card class="box-card" v-text="invoiceInFormation.invoiceNum">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="发票金额:">
		      <el-card class="box-card" v-text="invoiceInFormation.money">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="发票状态:">
		      <el-card class="box-card" v-text="invoiceInFormation.state">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="收/退费时间:">
		      <el-card class="box-card" v-text="invoiceInFormation.creationTime">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="收/退费人员ID:">
		      <el-card class="box-card" v-text="invoiceInFormation.userID">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="挂号ID:">
		      <el-card class="box-card" v-text="invoiceInFormation.registID">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="收费方式:">
		      <el-card class="box-card" v-text="invoiceInFormation.feeType">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="冲红发票号码:">
		      <el-card class="box-card" v-text="invoiceInFormation.back">
		      </el-card>
		    </el-form-item>
		    <el-form-item label="发票状态:">
		      <el-card class="box-card" v-text="invoiceInFormation.dailyState">
		      </el-card>
		    </el-form-item>
		  </el-form>
		  <span slot="footer" class="dialog-footer">
		    <el-button @click="dialogInvoice = false">取 消</el-button>
		    <el-button type="success" @click="dialogInvoice = false">确 定</el-button>
		</span>
		</el-dialog>
	</div>
	
	
	
</template>

<script setup>
	import axios from 'axios'
	import qs from 'qs'
	import {ref, inject} from 'vue'
	const tableData = ref([]); //表示查询结果
	import {
			ElMessageBox,
			ElMessage
		} from 'element-plus'
	
	
	import {
		useRouter
	} from 'vue-router'
	const router = useRouter();
	const value = ref('')
	const user = ref({
		CaseNumber: '',
		RealName: '',
		Gender:'',
		idnumber:'',
		BirthDate:'',
		Age:'',
		AgeType:'',
		HomeAddress:'',
		VisitDate:'',
		Noon:'',
		DeptID:'',
		UserID:'',
		RegistLeID:'',
		SettleID:'',
		IsBook:'',
		RegistTime:'',
		RegisterID:'',
		VisitState:'',
		
	});
	
	async function fetchData() {
		// 模拟异步获取数据
		return new Promise((resolve) => {
			setTimeout(() => {
				resolve();
			}, 1000);
		});
	}
	
	

const list = ref([]);
const items_list = ref([]);
const drugs_list = ref([]);
const query_num = ref('');
const registerID = ref('');
const disabledCharge = ref(true);
const dialogInvoice = ref(false);
const invoiceInFormation = ref({
  id: '',
  invoiceNum: '',
  money: '',
  userID: '',
  state: '',
  registID: '',
  feeType: '',
  dailyState: '',
  createTime: '',
  back: '',
});
	
const getCharge = (data) => {
  disabledCharge.value = false;
  console.log("data=", data);
  console.log(data.id);
  axios.post(`/charge/allItem?ID=${data.id}`)
    .then((resp) => {
      items_list.value = resp.data.data;
      console.log('items_list=', items_list.value);
    })
    .catch((err) => {
      console.log("err", err);
    });

  axios.post(`/charge/allDrugs?ID=${data.id}`)
    .then((resp) => {
      drugs_list.value = resp.data.data;
      console.log('drugs_list=', drugs_list.value);
    })
    .catch((err) => {
      console.log("err", err);
    });
}
const isGender = (row ={}, column = {}) => {
	if(row[column.property] ===71){
		
		return '男';
	}
	else{
		return '女'
	}
	
	
};


const doCharge = (data) => {
  axios.post(`/charge/allCharge?ID=${data.id}`).then((resp) => {
    invoiceInFormation.value = resp.data.data;
    console.log('invoiceInFormation=', invoiceInFormation.value);
  }).catch((err) => {
    console.log("err", err);
  });
  dialogInvoice.value = true;
};
	
	
	
	
const msg1 = ref('');

	// 五个模块路由跳转
	const toregister = () => {
		router.push('')
	}
	const todoc = () => {
		router.push('')
	}
	const totech = () => {
		router.push('')
	}
	const todrug = () => {
		router.push('')
	}
	const tofinance = () => {
		router.push('')
	}
	
	
	
	
	
	
	//三个子模块跳转 自己写
	const Reg = () => {
		router.push('/Reg')
	}
	const Xixi = () => {
		router.push('/Charge')
	}
	
	const Back = () => {
		router.push('/tuifei')
	}




	// 查询方法，名字可以改




	const query = () => {
let url='/register_clerk/selectAll';
	axios.post(url, qs.stringify(user.value))
		.then((resp)=>{
			let data = resp.data.data;
			console.log('data=', data);
			tableData.value=data;
		})
		.catch((err)=>{console.log('err=', err);});
	}
	
	
	const state2 = () => {

	}
	const state3 = () => {

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
		display: flex;
		background-image: url(../assets/main.jpg);
		background-size: 100% ;
	}

	aside {
		width: 150px;
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
	.content{
			    margin-left: 20%;
			    position: absolute;
	}

	footer {
		width: 100%;
		height: 100px;
	}
</style>
