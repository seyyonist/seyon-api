package io.seyon.client.config;

public class GstnAlreadyExistException extends Exception {


		private static final long serialVersionUID = -7962683088304818600L;

		public GstnAlreadyExistException(){
			super();
		}
		
		public GstnAlreadyExistException(String message){
			super(message);
		}

}
