package cn.com.model;

public class TransforRecord {

	private double age;
	private double job;
	private double marital;
	private double education;
	private double defaultCredit;
	private double housing;
	private double loan;
	private double contact;
	private double month;
	private double dayOfWeek;
	private double duration;
	private double campaign;
	private double pdays;
	private double previous;
	private double poutcome;
	private double empVarRate;
	private double consPriceIdx;
	private double consConfIdx;
	private double euribor3m;
	private double nrEmployed;
	private boolean isDirty;
	
	private String label;
	
	public void transforJob(String job){
		
		if(job.equals("admin."))
			this.job = 0.1;
		else if(job.equals("blue-collar"))
			this.job = 0.2;
		else if(job.equals("entrepreneur"))
			this.job = 0.3;
		else if(job.equals("housemaid"))
			this.job = 0.4;
		else if(job.equals("management"))
			this.job = 0.5;
		else if(job.equals("retired"))
			this.job = 0.6;
		else if(job.equals("self-employed"))
			this.job = 0.7;
		else if(job.equals("services"))
			this.job = 0.8;
		else if(job.equals("student"))
			this.job = 0.9;
		else if(job.equals("technician"))
			this.job = 1;
		else if(job.equals("unemployed"))
			this.job = 0.05;
		else if(job.equals("unknown")){
			this.isDirty = true;
		}else {
			this.isDirty = true;
		}
	}
	
	public void transforMarital(String marital){
		
		if(marital.equals("divorced"))
			this.marital = 0.1;
		else if(marital.equals("married"))
			this.marital = 0.2;
		else if(marital.equals("single"))
			this.marital = 0.3;
		else if(marital.equals("unknown")){
			this.isDirty = true;
		}else{
			this.isDirty = true;
		}
	}
	
	public void transforEducation(String education){
		
		if(education.equals("basic.4y"))
			this.education = 0.1;
		else if(education.equals("basic.6y"))
			this.education = 0.2;
		else if(education.equals("basic.9y"))
			this.education = 0.3;
		else if(education.equals("high.school"))
			this.education = 0.4;
		else if(education.equals("illiterate"))
			this.education = 0.5;
		else if(education.equals("professional.course"))
			this.education = 0.6;
		else if(education.equals("university.degree"))
			this.education = 0.7;
		else if(education.equals("unknown")){
			this.isDirty = true;
		}else {
			this.isDirty = true;
		}
	}

	public void transforDefaultCredit(String defaultCredit){
		
		if(defaultCredit.equals("no"))
			this.defaultCredit = 0.5;
		else if(defaultCredit.equals("yes"))
			this.defaultCredit = 1;
		else if(defaultCredit.equals("unknown")){
			this.isDirty = true;
		}else {
			this.isDirty = true;
		}
		
	}
	
	public void transforHousing(String housing){
		
		if(housing.equals("no"))
			this.housing = 0.5;
		else if(housing.equals("yes"))
			this.housing = 1;
		else if(housing.equals("unknown")){
			this.isDirty = true;
		}else{
			this.isDirty = true;
		}
	}
	
	public void transforLoan(String loan){
		
		if(loan.equals("no"))
			this.loan = 0.5;
		else if(loan.equals("yes"))
			this.loan = 1;
		else if(loan.equals("unknown")){
			this.isDirty = true;
		}else{
			this.isDirty = true;
		}
	}
	
	public void transforContact(String contact){
		
		if(contact.equals("cellular"))
			this.contact = 0.5;
		else if(contact.equals("telephone"))
			this.loan = 1;
		else if(contact.equals("unknown")){
			this.isDirty = true;
		}else{
			this.isDirty = true;
		}
	}

	public void transforMonth(String month){
		
		if(month.equals("jan"))
			this.month = 0;
		else if(month.equals("feb"))
			this.month = 2.0/12;
		else if(month.equals("mar"))
			this.month = 3.0/12;
		else if(month.equals("apr"))
			this.month = 4.0/12;
		else if(month.equals("may"))
			this.month = 5.0/12;
		else if(month.equals("jun"))
			this.month = 6.0/12;
		else if(month.equals("jul"))
			this.month = 7.0/12;
		else if(month.equals("aug"))
			this.month = 8.0/12;
		else if(month.equals("sep"))
			this.month = 9.0/12;
		else if(month.equals("oct"))
			this.month = 10.0/12;
		else if(month.equals("nov"))
			this.month = 11.0/12;
		else if(month.equals("dec"))
			this.month = 12.0/12;
		
	}
	
	public void transforDayOfWeek(String dayOfWeek){
		
		if(dayOfWeek.equals("mon"))
			this.dayOfWeek = 0.1;
		else if(dayOfWeek.equals("tue"))
			this.dayOfWeek = 0.2;
		else if(dayOfWeek.equals("wed"))
			this.dayOfWeek = 0.3;
		else if(dayOfWeek.equals("thu"))
			this.dayOfWeek = 0.4;
		else if(dayOfWeek.equals("fri"))
			this.dayOfWeek = 0.5;
	}
	
	public void transforPoutcome(String poutome){
		
		if(poutome.equals("failure"))
			this.poutcome = 0.1;
		else if(poutome.equals("nonexistent"))
			this.poutcome = 0.2;
		else if(poutome.equals("success"))
			this.poutcome = 0.3;
	} 
	
	public double getAge() {
		return age;
	}
	public void setAge(double age) {
		this.age = age;
	}
	public double getJob() {
		return job;
	}
	public void setJob(double job) {
		this.job = job;
	}
	public double getMarital() {
		return marital;
	}
	public void setMarital(double marital) {
		this.marital = marital;
	}
	public double getEducation() {
		return education;
	}
	public void setEducation(double education) {
		this.education = education;
	}
	public double getDefaultCredit() {
		return defaultCredit;
	}
	public void setDefaultCredit(double defaultCredit) {
		this.defaultCredit = defaultCredit;
	}
	public double getHousing() {
		return housing;
	}
	public void setHousing(double housing) {
		this.housing = housing;
	}
	public double getLoan() {
		return loan;
	}
	public void setLoan(double loan) {
		this.loan = loan;
	}
	public double getContact() {
		return contact;
	}
	public void setContact(double contact) {
		this.contact = contact;
	}
	public double getMonth() {
		return month;
	}
	public void setMonth(double month) {
		this.month = month;
	}
	public double getDayOfWeek() {
		return dayOfWeek;
	}
	public void setDayOfWeek(double dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}
	public double getDuration() {
		return duration;
	}
	public void setDuration(double duration) {
		this.duration = duration;
	}
	public double getCampaign() {
		return campaign;
	}
	public void setCampaign(double campaign) {
		this.campaign = campaign;
	}
	public double getPdays() {
		return pdays;
	}
	public void setPdays(double pdays) {
		this.pdays = pdays;
	}
	public double getPrevious() {
		return previous;
	}
	public void setPrevious(double previous) {
		this.previous = previous;
	}
	public double getPoutcome() {
		return poutcome;
	}
	public void setPoutcome(double poutcome) {
		this.poutcome = poutcome;
	}
	public double getEmpVarRate() {
		return empVarRate;
	}
	public void setEmpVarRate(double empVarRate) {
		this.empVarRate = empVarRate;
	}
	public double getConsPriceIdx() {
		return consPriceIdx;
	}
	public void setConsPriceIdx(double consPriceIdx) {
		this.consPriceIdx = consPriceIdx;
	}
	public double getConsConfIdx() {
		return consConfIdx;
	}
	public void setConsConfIdx(double consConfIdx) {
		this.consConfIdx = consConfIdx;
	}
	public double getEuribor3m() {
		return euribor3m;
	}
	public void setEuribor3m(double euribor3m) {
		this.euribor3m = euribor3m;
	}
	public double getNrEmployed() {
		return nrEmployed;
	}
	public void setNrEmployed(double nrEmployed) {
		this.nrEmployed = nrEmployed;
	}
	public String getLabel() {
		return label;
	}

	public boolean isDirty() {
		return isDirty;
	}
	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}
	public void setLabel(String label) {
		this.label = label;
	}
}
