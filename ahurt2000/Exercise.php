<?php

require_once dirname(__FILE__) . '/src/Field.php';

class Exercise
{
    private $fields;
    private $debug;
    
    public function __construct(){
        $this->fields = array();
    }

    private function getFieldDimensions($line)
    {
        list($n, $m) = explode(' ', $line); //inverted read            
        return array($m, $n);
    }
    
    private function IsTheEnd($m,$n)
    {
        return (($m + $n) == 0);
    }
    
    private function isValidDim($m, $n)
    {
        return ($m > 0 && $m <= 100 && $n > 0 );
    }
    
    private function isNewField($line)
    {
        return ( strlen(trim($line)) == 3 ) ;
    }

    public function process($input)
    {
        $id = 0;
        $minesAll  = array();
        while(count($input)>0)
        {           
            $line = array_shift($input);    
            
            if($this->isNewField($line))
            {
                $dim = $this->getFieldDimensions($line);
                $m = $dim[0]; 
                $n = $dim[1]; 
                if(!$this->IsTheEnd($m, $n))
                {
                    if(!$this->isValidDim($m, $n)){
                        throw new Exception ("Error: Invalid field dimensions! $m, $n");
                    }
                    ++$id;
                    $lineNum = 0;
                    $field = new Field($id, $m, $n);
                    $field->setDebug($this->debug);
                    $this->fields[$id] = $field;  
                }             
            }
            else
            {                                
                if( count($this->fields)<=0 ){
                    throw new Exception ("Error something wrong\n");
                }
                $field = $this->getField($id);
                $id = $field->getFieldId();

                /* line data process */
                foreach(str_split($line) as $x=>$cellvalue)
                {
                    $field->addCell($x, $lineNum);
                    /* detecting mines */
                    if($this->isMinedCell($cellvalue)){
                       $minesAll[$id][] = array($x, $lineNum);
                    }
                }
                $this->fields[$id] = $field;
                $lineNum++;
            }
        } 
        
        if(count($minesAll)>0)
        {
            foreach($minesAll as $id=>$mines)
            {
                $field = $this->getField($id); 
                $field = $this->MineField($field, $mines);
            }
            
        }
        
        return $this->getOutput();
    }
    
    private function getField($id)
    {
        return $this->fields[$id];
    }
    
    private function MineField($field, $mines)
    {
        foreach($mines as $cord)
        {
            $field->mineCell($cord[0], $cord[1]);
        }
        return $field;
    }
    
    
    public function getOutput()
    {
        $out = array();
        foreach ($this->fields as $field)
        {
           $out = array_merge($out,$field->printField());
           $out[]='';
        }
        
        return $out;
    }
    
    private function isMinedCell($value){    
        $out = false;
        switch ($value){
            case '*':
                // mined cell
                $out = true;
                break;
            case '.':
                // normal cell
                break;
            default:
                throw new Exception("Cell content error");
        }
        return $out;
    }
    
    public function setDebug($value) {
        $this->debug = $value;
    }    
}
