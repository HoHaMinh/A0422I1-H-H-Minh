import {EducationLevel} from './education-level';
import {EmployeePosition} from './employee-position';

export interface Employee {
  id?: number;
  name?: string;
  birthday?: string;
  personCode?: string;
  phoneNumber?: string;
  email?: string;
  educationLevel?: EducationLevel;
  position?: EmployeePosition;
  salary?: number;
}
