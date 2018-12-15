package ru.kpfu.itis.photoeditor.filters;
/**
 * @author Vadim Guryanov <gvadimmonstors@mail.ru>
 * @version 1.0
 * This interface characterizes class as being a filter with variable change degree.
 */
public interface PercentageVariable extends Filter{
    /**
     * Sets change degree for filter object (if supported).
     * @param coefficient
     */
    void setPercentage(int coefficient);
}
