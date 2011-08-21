<?php

require_once PATH_BASE . '/SourceInterface.php';

/**
 * Class for extract the data from a source file.
 */
class SourceFile implements SourceInterface
{
    /**
     * Filename of the source.
     *
     * @var string
     */
    protected $source;
    
    /**
     * Sets the source filename.
     * 
     * @param mixed $source
     */
    public function setSource( $source )
    {}

    /**
     * Returns the data to the Minesweeper.
     * 
     * @return array
     */
    public function getData()
    {}

}