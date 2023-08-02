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
						<el-link type="success" el-button @click="Charge()" style="font-size:x-large">收费 </el-link><br /><br />
						<el-link type="success" el-button @click="Back()" style="font-size:x-large">退号 </el-link><br />
					</div>
				</el-aside>
				<el-container>
					<el-main>
						<el-form class="my-query" style="width: 100%; align-items: center;">
							<el-form-item label="病例号">
								<el-input type="text" v-model="user.CaseNumber"></el-input>
							</el-form-item>
							<el-form-item label="真实姓名">
								<el-input type="text" v-model="user.RealName"></el-input>
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
										<el-button type="info" @click='doprint(scope.row)'>显示发票</el-button>
									
									</template>
								</el-table-column>
							</el-table>
						</el-form>
					</el-main>
					<el-footer style="border-top: 1px solid #bebebe;"></el-footer>
				</el-container>
			</el-container>
		</el-container>
	</div>
	
	<el-form class="my-form" style="width: 1000px; float:right;margin: 1 auto;">
	<div class="my-button" style="  margin: 20px auto; align-items: center;">
			<el-form-item>
				<el-form-item label="身份证号">
					<el-input type="text" v-model="user.IDnumber" style="float: right;"></el-input>
				</el-form-item>
				&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
				<el-button type="info" class="btn-center" @click='doAdd()'>
					挂号</el-button>
			
	
			</el-form-item>
		</div>
		<div class="my-in" style=" display: flex ; margin: 20px auto; align-items: center;">
			<el-form-item label="病例号">
				<el-input type="text" v-model="user.CaseNumber"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="真实姓名">
				<el-input type="text" v-model="user.RealName"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			
		   <el-select v-model="user.Gender" class="m-2" placeholder="选择性别">
		     <el-option
		       v-for="option in options"
		       :key="option.value"
		       :label="option.label"
		       :value="option.value"
		     />
			  </el-select>
		
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="年龄">
				<!-- 待改 -->
				<el-input type="text" v-model="user.Age"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item>
				<!-- 待改 -->
				<div class="demo-datetime-picker">
					<div class="block">
						<span class="demonstration">出生日期</span>
						<el-date-picker v-model="user.BirthDate" type="date" placeholder="Pick a day"   :disabled-date="disabledDate"
	    :shortcuts="shortcuts"
	    :size="size" />
					</div>
				</div>
				<!-- <el-input type="text" v-model="user.realname"></el-input> -->
			</el-form-item>
	
		</div>
		
		<div class="my-in2" style=" display: flex ; margin: 20px auto; align-items: center;">
			<el-form-item label="HomeAddress">
				<el-input type="text" v-model="user.HomeAddress"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="Noon">
				<el-input type="text" v-model="user.Noon"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="ReGIsterID">
				<!-- 待改 -->
				<el-input type="text" v-model="user.RegisterID"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="AgeType">
				<!-- 待改 -->
				<el-input type="text" v-model="user.AgeType"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item>
				<!-- 待改 -->
				<div class="demo-datetime-picker">
					<div class="block">
						<span class="demonstration">检查日期</span>
						<el-date-picker v-model="user.VisitDate" type="date" placeholder="Pick a day"   :disabled-date="disabledDate"
		:shortcuts="shortcuts"
		:size="size" />
					</div>
				</div>
				<!-- <el-input type="text" v-model="user.realname"></el-input> -->
			</el-form-item>
		
		</div>
		
		<div class="my-in3" style=" display: flex ; margin: 20px auto; align-items: center;">
			<el-form-item label="部门ID">
				<el-input type="text" v-model="user.DeptID"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="UserID">
				<el-input type="text" v-model="user.UserID"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			
			<el-select v-model="user.RegistLeID" class="m-2" placeholder="挂号级别">
			  <el-option
			    v-for="option in options3"
			    :key="option.value"
			    :label="option.label"
			    :value="option.value"
			  />
						  </el-select>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item label="SettleID">
				<!-- 待改 -->
				<el-input type="text" v-model="user.SettleID"></el-input>
			</el-form-item>
			&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
			<el-form-item>
				<!-- 待改 -->
		  <div class="demo-datetime-picker">
		    <div class="block">
		      <span class="demonstration">挂号日期</span>
		      <div class="demonstration"> {{ user.RegistTime }}</div>
		      <el-date-picker
		        v-model="user.RegistTime"
		        type="datetime"
		        placeholder="Pick a Date"
		        format="YYYY/MM/DD HH:mm:ss"
		      />
			  
		    </div>			
			</div>
			</el-form-item>
		
	      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	      
	      <el-select v-model="user.IsBook" class="m-2" placeholder="病历本">
	        <el-option
	          v-for="option in options1"
	          :key="option.value"
	          :label="option.label"
	          :value="option.value"
	        />
	      			  </el-select>
	      					  
	      &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
	      <el-select v-model="user.VisitState" class="m-2" placeholder="挂号状态">
	        <el-option
	          v-for="option in options2"
	          :key="option.value"
	          :label="option.label"
	          :value="option.value"
	        />
	      			  </el-select>		
		</div>
	
		<div style="width: 100%;">
			<span></span>
			<el-divider />
			<span></span>
		</div>
	</el-form>
	<el-dialog
	    title="发票信息"
	    v-model="dialogPrint"
	    width="45%"
	    center>
	  <el-form
	      ref="form"
	      v-model="invoice"
	      label-width="150px">
	    <el-form-item label="发票编号:">
	     <el-card class="box-card" v-text="invoice.invoiceNum">
	     </el-card>
	    </el-form-item>
	    <el-form-item label="发票金额:">
	      <el-card class="box-card" v-text="invoice.money">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="发票状态:">
	      <el-card class="box-card" v-text="invoice.state">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="收/退费时间:">
	      <el-card class="box-card" v-text="invoice.creationTime">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="收/退费人员ID:">
	      <el-card class="box-card" v-text="invoice.userID">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="挂号ID:">
	      <el-card class="box-card" v-text="invoice.registID">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="收费方式:">
	      <el-card class="box-card" v-text="invoice.feeType">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="冲红发票号码:">
	      <el-card class="box-card" v-text="invoice.back">
	      </el-card>
	    </el-form-item>
	    <el-form-item label="发票状态:">
	      <el-card class="box-card" v-text="invoice.dailyState">
	      </el-card>
	    </el-form-item>
	  </el-form>
	  <span slot="footer" class="dialog-footer">
	    <el-button @click="dialogPrint = false">取 消</el-button>
	    <el-button type="primary" @click="dialogPrint = false">确 定</el-button>
	</span>
	</el-dialog>
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
	const options = [
	  {
	    value: '71',
	    label: '女',
	  },
	  {
	    value: '72',
	    label: '男',
	  },]
	  
	  const options1 = [
	    {
	      value: '1',
	      label: '要',
	    },
	    {
	      value: '0',
	      label: '不要',
	    },]
		
		const options2 = [
		  {
		    value: '1',
		    label: '已挂号',
		  },
		  {
		    value: '2',
		    label: '医生接诊',
		  },
		  {
		    value: '3',
		    label: '看诊结束',
		  },
		  ]
		  
		  const options3 = [
		    {
		      value: '2',
		      label: '普通号',
		    },
		    {
		      value: '1',
		      label: '专家号',
		    },]

	const user = ref({
		CaseNumber: '',
		RealName: '',
		Gender:'',
		IDnumber:'',
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
	const Charge = () => {
		router.push('/Charge')
	}
	
	const Back = () => {
		router.push('/tuifei')
	}
	
	async function fetchData() {
		// 模拟异步获取数据
		return new Promise((resolve) => {
			setTimeout(() => {
				resolve();
			}, 1000);
		});
	}
	

	// 查询方法，名字可以改

const invoice = ref({
		InvoiceNum: '',
		Money: '',
		State: '',
		CreationTime: '',
		UserID: '',
		RegistID: '',
		FeeType: '',
		Back: '',
		DailyState: '',

	});
	const dialogPrint=ref(false);
	
	
	
	const doprint = (data) => {
			console.log(data);
			console.log(user);
			ElMessageBox.confirm('打印发票, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				})
				.then(() => {
					axios.post('/register_clerk/print', data)
						.then((resp) => {
							invoice.value = resp.data.data;
							dialogPrint.value = true;
							console.log("invoice:", invoice)
							console.log("msg :", resp.data.msg);
							if (resp.data.msg = '打印成功') {
	
							}
						})
						.catch((err) => {
							console.log("err", err);
						});
	
				})
				.catch(() => {
					if (dialogPrint.value = true) {
						ElMessage({
							type: 'info',
							message: '已打印'
						});
					} else
						ElMessage({
							type: 'info',
							message: '已取消打印'
						});
				});
		};

const doAdd = () => {
	
		let url = '/register_clerk/register';
		axios.post(url, qs.stringify(user.value))
			.then((resp) => {
				let data = resp.data.data;
				console.log('data=', data);
				//list.value=data;
				
				if (data != 0) {
					//提示增加成功
					msg1.value = '挂号成功'

				} else {
					msg1.value = '增加失败，请联系管理员处理'
				}

			})
			.catch((err) => {
				console.log('err=', err);
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
	const value1 = ref('')
	const value2 = ref('')
	const value3 = ref('')
	const defaultTime = new Date(2000, 1, 1, 12, 0, 0)
	
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
