package lk.ijse.smarttravelapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
 @AllArgsConstructor
public class APIResponse<T> {
     private int code;
     private String message;
     private Object data;
}
