<?php

require_once dirname(__FILE__) . '/../../src/SquareBomb.php';

/**
 * Test class for SquareBomb.
 */
class SquareBombTest extends PHPUnit_Framework_TestCase
{

    /**
     * @var SquareBomb
     */
    protected $object;

    /**
     * Sets up the fixture, for example, opens a network connection.
     * This method is called before a test is executed.
     */
    protected function setUp()
    {
        $this->object = new SquareBomb;
    }

    /**
     * Test the method __toString().
     */
    public function test__toString()
    {
        $result     = $this->object->__toString();
        $expected   = '*';
        
        $this->assertEquals( $result, $expected, 'The method "__toString()" doesn\'t return an asterisc.' );
    }

}

?>
