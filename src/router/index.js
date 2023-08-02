import {
	createRouter,
	createWebHashHistory
} from 'vue-router'
import drugquery from '../views/drugquery.vue'
import add from '../views/add.vue'
import drugupdate from '../views/drugupdate.vue'
import drugadd from '../views/drugadd.vue'
import outpatientdispensing from '../views/outpatientdispensing.vue'
import outpatientwithdrawal from '../views/outpatientwithdrawal.vue'
import back from '../views/back.vue'
import index from '../views/index.vue'

//门诊医生工作站
import OutpatientDoctorWorkStation_DiagnosisCompleted from '../views/DiagnosisCompleted.vue'
import OutpatientDoctorWorkStation_PersonalWorkloadStatistics from '../views/PersonalWorkloadStatistics.vue'
import OutpatientDoctorWorkStation_OutpatientDiagnosis from '../views/OutpatientDiagnosis.vue'
import OutpatientDoctorWorkStation_InspectionApplication from '../views/InspectionApplication.vue'
import OutpatientDoctorWorkStation_PatentPrescription from '../views/PatentPrescription.vue'


// 财务
import ExpAdd from '../views/expenseclass/ExpAdd.vue'
import ExpQuery from '../views/expenseclass/ExpQuery.vue'
import ExpUpdate from '../views/expenseclass/ExpUpdate.vue'
import InvoiceQuery from '../views/outpatientfinance/InvoiceQuery.vue'
import WorkloadStatisticsQuery from '../views/outpatientdepartmentworkloadstatistics/WorkloadStatisticsQuery.vue'
 import caiwu from '../views/caiwu.vue'
 
 // 挂号
 import Reg from '../views/Reg.vue'
 import Charge from '../views/Charge.vue'
 import tuifei from '../views/tuifei.vue'
 
const routes = [{
		path: '/',
		redirect: '/index'
	},
	{
		path: '/drugquery',
		name: 'drugquery',
		component: drugquery
	},
	{
		path: '/add',
		name: 'add',
		component: add
	},
	{
		path: '/drugupdate',
		name: 'drugupdate',
		component: drugupdate
	},
	{
		path: '/drugadd',
		name: 'drugadd',
		component: drugadd
	},
	{
		path: '/outpatientdispensing',
		name: 'outpatientdispensing',
		component: outpatientdispensing
	},
	{
		path: '/outpatientwithdrawal',
		name: 'outpatientwithdrawal',
		component: outpatientwithdrawal
	},
	{
		path: '/back',
		name: 'back',
		component: back
	},
	{
		path: '/index',
		name: 'index',
		component: index
	},
	//门诊医生工作站
	{
		path: '/DiagnosisCompleted',
		name: 'OutpatientDoctorWorkStation_DiagnosisCompleted',
		component: OutpatientDoctorWorkStation_DiagnosisCompleted
	},
	{
		path: '/PersonalWorkloadStatistics',
		name: 'OutpatientDoctorWorkStation_PersonalWorkloadStatistics',
		component: OutpatientDoctorWorkStation_PersonalWorkloadStatistics
	},
	{
		path: '/OutpatientDiagnosis',
		name: 'OutpatientDoctorWorkStation_OutpatientDiagnosis',
		component: OutpatientDoctorWorkStation_OutpatientDiagnosis
	},
	{
		path: '/InspectionApplication',
		name: 'OutpatientDoctorWorkStation_InspectionApplication',
		component: OutpatientDoctorWorkStation_InspectionApplication
	},
	{
		path: '/PatentPrescription',
		name: 'OutpatientDoctorWorkStation_PatentPrescription',
		component: OutpatientDoctorWorkStation_PatentPrescription
	},
	//财务
	 {
	  path: '/caiwu',
	  name: 'caiwu',
	  component: caiwu,
	  children:[
	   {
	    path:'/expenseclass/ExpQuery',
	    name:'ExpQuery',
	    component:ExpQuery
	   },
	   {
	    path:'/expenseclass/ExpAdd',
	    name:'ExpAdd',
	    component:ExpAdd
	   },
	  {
	   path:'/expenseclass/ExpUpdate',
	   name:'ExpUpdate',
	   component:ExpUpdate
	  },
	  {
	   path:'/outpatientfinance/InvoiceQuery',
	   name:'InvoiceQuery',
	   component:InvoiceQuery
	  },
	  {
	   path:'/outpatientdepartmentworkloadstatistics/WorkloadStatisticsQuery',
	   name:'WorkloadStatisticsQuery',
	   component:WorkloadStatisticsQuery
	  },
	  
	  
	  
	  ],
	  },
	  // 挂号
	  {
	   path:'/Reg',
	   name:'Reg',
	   component:Reg
	  },
	  {
	   path:'/Charge',
	   name:'Charge',
	   component:Charge
	  },
	  {
	   path:'/tuifei',
	   name:'tuifei',
	   component:tuifei
	  },





]

const router = createRouter({
	history: createWebHashHistory(),
	routes
})

export default router
