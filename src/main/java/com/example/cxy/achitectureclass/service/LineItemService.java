package com.example.cxy.achitectureclass.service;

import com.example.cxy.achitectureclass.common.service.LogicService;
import com.example.cxy.achitectureclass.dao.LineItemDao;
import com.example.cxy.achitectureclass.dto.LineItemInfo;
import com.example.cxy.achitectureclass.entity.LineItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LineItemService extends LogicService<LineItemDao, LineItem, Long> {

    public LineItemService(@Autowired LineItemDao lr) {
        super(lr);
    }

    public List<LineItemInfo> getLineItemsInfoForOrder(Long orderId) {
        return getDAO().findUserByOrderById(orderId).stream().map(item -> {
            LineItemInfo lineItemInfo = new LineItemInfo();
            lineItemInfo.setId(item.getId());
            lineItemInfo.setQuantity(item.getQuantity());
            return lineItemInfo;
        }).collect(Collectors.toList());
    }
}
