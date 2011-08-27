<?php

require_once 'Field.php';

/**
 * Class Minesweeper that resolves fields.
 */
class Minesweeper
{
    /**
     * Set of Fields.
     *
     * @var array
     */
    protected $fields = array();
    
    /**
     * Sets the data from the source.
     *
     * @param array $data
     */
    public function setData( array $data )
    {
        $line = 0;

        while ( '0 0' != $data[ $line ] )
        {
            list( $rowsNum, $colsNum ) = explode( ' ', $data[ $line ] );
            $field = new Field( $rowsNum, $colsNum );
            $this->fields[] = $field;

            $line++;
            for ( $row = 0; $row < $rowsNum; $row++ )
            {
                for ( $col = 0; $col < $colsNum; $col++ )
                {
                    if ( '*' == $data[ $line ][ $col ] )
                    {
                        $field->setSquareBomb( $row, $col );
                    }
                }
                $line++;
            }
        }
    }

    /**
     * Prints the solutions of the fields.
     * 
     * 
     */
    public function printSolutions()
    {
        $output = '';

        foreach( $this->fields as $index => $field )
        {
            $output .= 'Field #' . ( $index + 1 ) . ':' . PHP_EOL;
            $output .= $field->__toString() . PHP_EOL;
        }
        
        $output = substr( $output, 0, -1 );
        
        return $output;
    }
}