import axios from 'axios'

const EMPLOYEE_SERVICE_BASE_URL = 'http://localhost:9191/v1/employees'

const EMPLOYEE_ID = 2

class EmployeeService {

    getEmployees() {
        const uri = EMPLOYEE_SERVICE_BASE_URL + '/' + EMPLOYEE_ID + '/info'
        console.log(uri)
        return axios.get(uri)
    }

}

export default new EmployeeService