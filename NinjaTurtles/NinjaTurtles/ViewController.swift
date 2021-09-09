//
//  ViewController.swift
//  NinjaTurtles
//
//  Created by Alexander Hawkins on 8/31/21.
//

import UIKit

class ViewController: UIViewController
{

    override func viewDidLoad()
    {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }
    
    @IBOutlet weak var NTImage: UIImageView!
    
    @IBOutlet weak var Descriptions: UILabel!

    @IBAction func MovieAnimeBtns(_ sender: UIButton)
    {
        
        
        if sender.tag == 1
        {
            NTImage.image = UIImage(named: "NinjaTurtlesMovie");
            
            Descriptions.font = UIFont(name: "Marker Felt Thin", size: 22.2);
            
            Descriptions.textColor = UIColor.white;
            
            Descriptions.text = "The first Ninja Turtles movie was released on March 30, 1990.";
            
            Descriptions.numberOfLines = 2;
            
        }
        
        else if sender.tag == 2
        {
            NTImage.image = UIImage(named: "NinjaTurtlesAnime");
            
            Descriptions.font = UIFont(name: "Marker Felt Thin", size: 22.2);
            
            Descriptions.textColor = UIColor.white;
            
            Descriptions.text = "The first Ninja Turtles anime was released on December 28, 1987.";
            
            Descriptions.numberOfLines = 2;
            
        }
        
        
    }
    
}
