package com.example.labteacherservice.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.labteacherservice.entity.ReservationRecord;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ReservationRecordMapper extends BaseMapper<ReservationRecord> {
    //    @Select("select * from reservation_record")
//    List<ReservationRecord> listALLRecords();
    @Delete("delete from reservation_record where id = #{id}")
    public void deleteRecord(long id);
    @Select("select * from reservation_record where tid = #{tid}")
    List<ReservationRecord> getRecords(long tid);
    @Select("select * from reservation_record where lid = #{lid}")
    List<ReservationRecord> getRecordsByLid(long lid);
}
