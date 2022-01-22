export class Visit {
    // private int visitId;
	// private String customerName;
	// private String contactPerson;
	// private int contactNo;
	// private String interestedProduct;
	// private String visitSubject;
	// private String description;
	// @DateTimeFormat(pattern="yyyy-MM-dd-HH-mm-ss-ns")
	// private LocalDateTime visitDateTime;
	// private boolean isDisabled;
	// private boolean isDeleted;
	// private int empId;
    visitId:number;
    customerName:string;
    contactPerson:string;
    contactNo:number;
    interestedProduct:string;
    visitSubject:string;
    description:string;
    visitDateTime:Date =new Date;
    isDisabled:boolean;
    isDeleted:boolean;
    empId:number;


}
