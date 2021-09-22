//
//  ViewController.swift
//  Migos
//
//  Created by Alexander Hawkins on 9/9/21.
//

import UIKit

class ViewController: UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view.
    }

    //Outlets
    
    @IBOutlet weak var MigosImg: UIImageView!
    
    
    @IBOutlet weak var MigosLabel: UILabel!
    
    
    @IBOutlet weak var fontSizeLabel: UILabel!
    
    
    
    
    //Functions
    
    
    @IBAction func ChangeInfo(_ sender: UISegmentedControl)
    {
        if sender.selectedSegmentIndex == 0
        {
            MigosLabel.text = "Migos at the Met Gala";
            MigosImg.image = UIImage(named: "Migos2");
        }
        
        else if sender.selectedSegmentIndex == 1
        {
            MigosLabel.text = "Migos album Culture II out now";
            MigosImg.image = UIImage(named: "Migos3");
        }
        
    }
    
    
    
    @IBAction func updateFont(_ sender: UISwitch)
    {
        if sender.isOn
        {
            //Capitalize
            MigosLabel.text = MigosLabel.text?.uppercased()
        }
        
        else
        {
            //Lowercase
            MigosLabel.text = MigosLabel.text?.lowercased()
        }
        
    }
    
    
    
    @IBAction func changeFontSize(_ sender: UISlider)
    {
        let fontSize = sender.value
        
        fontSizeLabel.text = String(format: "%.0f", fontSize)
        
        let fontSizeCGFloat = CGFloat(fontSize)
        
        MigosLabel.font = UIFont.systemFont(ofSize: fontSizeCGFloat)
        
        
    }
    
    
    
}

