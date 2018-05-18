<?php
echo '<h1>Frontend</h1>';
echo gethostname();

echo '<h1>Backend</h1>';
echo file_get_contents('http://httpdbe');
