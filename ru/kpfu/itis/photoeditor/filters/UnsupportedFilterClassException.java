package ru.kpfu.itis.photoeditor.filters;

/**
 * @author Iskander Musin </musin.iskn@mail.ru>
 * @version 1.0
 * Thrown when unsupported type of filter is being to be applied by filter setter
 */
public class UnsupportedFilterClassException extends ClassCastException{
    public UnsupportedFilterClassException(String message){
        super(message);
    }
}
