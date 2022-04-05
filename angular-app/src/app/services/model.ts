export interface IUser {
  id: number;
  firstName: string;
  lastName: string;
  workExperience: string;
  photo: string;
  usernameTwitter: string;
}

export interface ITweet {
  text: string;
}

export class Constant {
  static readonly EMPTY_USER: IUser = {
    id: -1,
    firstName: '',
    lastName: '',
    workExperience: '',
    photo: '',
    usernameTwitter: ''
  };
  readonly LABEL_FIRST_NAME = 'First Name';
  readonly LABEL_LAST_NAME = 'Last Name';
  readonly LABEL_USERNAME_TWITTER = 'Username Twitter';
  readonly LABEL_PHOTO = 'URL Photo';
  readonly LABEL_WORK_EXPERIENCE = 'Work Experience';
  readonly LABEL_CREATE_USER = 'Create User';
  readonly LABEL_GET_USER = 'Detail User';
  readonly LABEL_MODIFY_USER = 'Modify User';
  readonly LABEL_CLOSE = 'Close';
  readonly LABEL_CREATE = 'Create';
  readonly LABEL_UPDATE = 'Update';
}

export class Globals {
  displayMenu = 'd-block';
  iconMenu = 'times';
}
