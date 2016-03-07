/**
 * 
 */
package util;

/**
 * @author Brandon
 *
 */

public class MException extends Exception {
      private String detail;
      private String nameClass;
      /**
       * Builder method that receive the decription of the exception generating 
       * 
       * 
       * @param error
       *        string that containts the error descrption
       */

      public MException(String clase,String error) {
        super(error);
        this.nameClass = clase; 
        detail = error;
      }

       public String toString() {
        return "["+nameClass+"] "+detail;
      }
 }
