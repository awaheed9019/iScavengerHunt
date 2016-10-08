<?php 
	echo "HEYYYYYYYYYYYYYYYYYYYY. It's the Punk!"; 
	include 'PHP_Text2Speech.class.php'; 
	$t2s = new PHP_Text2Speech; 
		
		
	if (!file_exists($this->mp3File)) { 
				$this->download("http://translate.google.com/translate_tts?ie=UTF-8&q={$this->text}&tl={$this->lang}&total={$this->wordCount}&idx=0&textlen={$this->textLen}", $this->mp3File); 
			}
?>

<audio controls="controls" autoplay="autoplay"> 
   <source src="<?php echo $t2s->speak("Hello");?>" type="audio/mp3" />    
</audio>