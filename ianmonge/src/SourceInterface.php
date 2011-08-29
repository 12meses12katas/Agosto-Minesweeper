<?php

/**
 * Interface for the Source classes.
 */
interface SourceInterface
{
    /**
     * Sets the source.
     * 
     * @param mixed $source
     */
    public function setSource( $source );

    /**
     * Returns the data to the Minesweeper.
     * 
     * @return array
     */
    public function getData();
}