package dataGridList;

import java.time.LocalDate;
;

public class PersonModel {
		private String name;
		private String email;
		private int age;
		private LocalDate birthday;
		
		
		
		public PersonModel(String name, String email, int age, LocalDate birtDay) {
			super();
			this.name = name;
			this.email = email;
			this.age = age;
			this.birthday = birtDay;
		}
		
		
		public PersonModel() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public LocalDate getBirthday() {
			return birthday;
		}
		public void setBirthday(LocalDate birtDay) {
			this.birthday = birtDay;
		}
		
		
		
}
