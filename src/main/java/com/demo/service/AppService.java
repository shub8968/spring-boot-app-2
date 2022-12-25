package com.demo.service;

import com.demo.eh.RecordNotFoundException;
import com.demo.model.RedCarpet;
import com.demo.repo.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    RecordRepository recordRepository;

    public RedCarpet getRecordById(Long id) {
        Optional<RedCarpet> record = recordRepository.findById(id);
        if (record.isPresent()) return record.get();
        else throw new RecordNotFoundException();
    }

    public List<RedCarpet> getRecord() {
        Iterable<RedCarpet> list = recordRepository.findAll();
        List<RedCarpet> listL = new ArrayList<>();
        for(RedCarpet x : list){
            listL.add(x);
        }
        return listL;
    }

    public void createRecord(RedCarpet redCarpet)  {
        try{
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = dateFormat.parse("23/09/2007");
            long time = date.getTime();
            redCarpet.setTimestamp(new Timestamp(time));
            recordRepository.save(redCarpet);

        }catch(ParseException e){
            throw new RecordNotFoundException();
        }

    }

    public void deleteRecordById(Long id) {
        recordRepository.deleteById(id);
    }

    public void updateRecord(RedCarpet RedCarpet) {
        recordRepository.save(RedCarpet);
    }
}
