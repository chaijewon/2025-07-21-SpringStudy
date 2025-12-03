package com.sist.chat;

import lombok.Data;

/*
 *    vo.setEventType(et.get(i).text());
            vo.setStartDate(st.get(i).text());
            vo.setLanesBlocked(lb.get(i).text());
            vo.setRoadName(rn.get(i).text());
            vo.setMessage(ms.get(i).text());
 */
@Data
public class CctvVO {
   private String eventType,startDate,lanesBlocked,roadName,message;
}
