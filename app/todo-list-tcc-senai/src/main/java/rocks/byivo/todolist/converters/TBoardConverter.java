/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rocks.byivo.todolist.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import rocks.byivo.todolist.model.TBoard;

/**
 *
 * @author byivo
 */
@Component
public class TBoardConverter implements Converter<String, TBoard> {

    @Override
    public TBoard convert(String text) {
        text = text.toUpperCase();
        
        TBoard board = TBoard.valueOf(text);
        
        return board;
    }
}
