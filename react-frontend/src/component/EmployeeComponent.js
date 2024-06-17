import React, {Component} from 'react';
import EmployeeService from "../service/EmployeeService";

class EmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employee: {},
            department: {},
            organization: {}
        }

    }

    componentDidMount() {
        EmployeeService.getEmployees().then(response => {
            const employee = response.data.employee
            const department = response.data.department
            const organization = response.data.organization

            this.setState({employee: employee})
            this.setState({department: department})
            this.setState({organization: organization})

            console.log(employee)
            console.log(department)
            console.log(organization)
        })
    }

    render() {
        return (
            <div>
                <div className="card">
                    <div className="card-body">
                        <h2 className="card-title">Employee with id <b>{this.state.employee.id}</b></h2>
                    </div>
                    <ul className="list-group list-group-flush">
                        <li className="list-group-item"><b>First name:</b> {this.state.employee.firstName}</li>
                        <li className="list-group-item"><b>Last name:</b> {this.state.employee.lastName}</li>
                        <li className="list-group-item"><b>Email:</b> {this.state.employee.email}</li>
                    </ul>
                </div>
                <div>
                    <div className="card">
                        <div className="card-body">
                            <h2 className="card-title"><b>Department:</b> {this.state.department.departmentName}</h2>
                        </div>
                        <ul className="list-group list-group-flush">
                            <li className="list-group-item"><b>Description:</b> {this.state.department.departmentDescription}</li>
                            <li className="list-group-item"><b>Code:</b> {this.state.department.departmentCode}</li>
                        </ul>
                    </div>
                </div>
                <div>
                    <div className="card">
                        <div className="card-body">
                            <h2 className="card-title"><b>Organization:</b> {this.state.organization.name}</h2>
                        </div>
                        <ul className="list-group list-group-flush">
                            <li className="list-group-item"><b>Description:</b> {this.state.organization.description}</li>
                            <li className="list-group-item"><b>Code:</b> {this.state.organization.code}</li>
                            <li className="list-group-item"><b>Creation date:</b> {this.state.organization.creationDate}</li>
                        </ul>
                    </div>
                </div>
            </div>
        );
    }
}

export default EmployeeComponent;